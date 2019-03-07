package emlearning.em.backend.domains.system.role.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlearning.em.backend.domains.system.role.constant.RoleNameConstant;
import emlearning.em.backend.domains.system.role.constant.RolesFileConstant;
import emlearning.em.backend.domains.system.role.entity.RoleEntity;
import emlearning.em.backend.domains.system.role.repository.RoleEntityRepository;

@Service
public class RoleService {

	@Autowired
	private RoleEntityRepository roleEntityRepository;

	public List<String> getAllRoles() throws InvalidFormatException, IOException {
		OPCPackage file = OPCPackage
				.open(new File(Paths.get("").toAbsolutePath().toString() + RolesFileConstant.ROLES_FILE));

		XSSFWorkbook excel = new XSSFWorkbook(file);
		XSSFSheet sheet = excel.getSheetAt(RolesFileConstant.ROLES_SHEET);
		Iterator<Row> rowIterator = sheet.iterator();

		Row row;
		List<String> allRole = new ArrayList<>();

		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			allRole.add(row.getCell(0).toString());
		}

		return allRole;
	}

	public void reloadAllRoles() throws InvalidFormatException, IOException {
		getAllRoles().forEach(role -> {
			if (!roleEntityRepository.existsByName(RoleNameConstant.valueOf(role))) {
				roleEntityRepository.save(new RoleEntity(RoleNameConstant.valueOf(role)));
			}
		});
	}

}
