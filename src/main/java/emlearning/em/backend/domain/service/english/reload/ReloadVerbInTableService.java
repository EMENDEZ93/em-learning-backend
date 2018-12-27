package emlearning.em.backend.domain.service.english.reload;

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

import emlearning.em.backend.domain.constant.english.ExcelEnglishFileConstant;
import emlearning.em.backend.domain.dto.english.verb.VerbDto;
import emlearning.em.backend.persistence.entity.english.verb.PastEntity;
import emlearning.em.backend.persistence.entity.english.verb.PastParticipleEntity;

public interface ReloadVerbInTableService {

	public void reloadAllVerb() throws IOException, InvalidFormatException;

	public void reloadPresentVerbInTable() throws InvalidFormatException, IOException;

	public PastEntity reloadPastVerbInTable(String pastVerb) throws InvalidFormatException, IOException;

	public PastParticipleEntity reloadPastParticipleVerbInTable(String pastParticipleVerb) throws InvalidFormatException, IOException;

	public default List<VerbDto> getAllverbForTime(int time) throws InvalidFormatException, IOException {
		OPCPackage file = OPCPackage
				.open(new File(Paths.get("").toAbsolutePath().toString() + ExcelEnglishFileConstant.VERB_FILE));

		XSSFWorkbook excel = new XSSFWorkbook(file);
		XSSFSheet sheet = excel.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();

		Row row;
		List<VerbDto> allVerb = new ArrayList<>();

		while (rowIterator.hasNext()) {
			row = rowIterator.next();

			VerbDto verb = new VerbDto();
			verb.setPresent(row.getCell(0).toString());
			verb.setPast(row.getCell(1).toString());
			verb.setPastParticiple(row.getCell(2).toString());

			allVerb.add(verb);

		}

		return allVerb;
	}

}
