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

public interface ReloadVerbInTableService {

	public void reloadAllVerb() throws IOException, InvalidFormatException;

	public void reloadPresentVerbInTable() throws InvalidFormatException, IOException;

	public default List<String> getAllverbForTime(int time) throws InvalidFormatException, IOException {
		OPCPackage file = OPCPackage
				.open(new File(Paths.get("").toAbsolutePath().toString() + ExcelEnglishFileConstant.VERB_FILE));

		XSSFWorkbook excel = new XSSFWorkbook(file);
		XSSFSheet sheet = excel.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();

		Row row;
		List<String> allVerb = new ArrayList<>();

		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			allVerb.add(row.getCell(time).toString());
		}

		return allVerb;
	}

}
