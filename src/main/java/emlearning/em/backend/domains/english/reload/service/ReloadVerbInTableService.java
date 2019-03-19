package emlearning.em.backend.domains.english.reload.service;

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

import emlearning.em.backend.application.query.english.verb.VerbDto;
import emlearning.em.backend.domains.english.constant.ExcelEnglishFileConstant;
import emlearning.em.backend.domains.english.practice.example.entity.ExampleVerbEntity;
import emlearning.em.backend.domains.english.practice.pastparticiple.entity.PastParticipleEntity;

public interface ReloadVerbInTableService {

	public void reloadAllVerb() throws IOException, InvalidFormatException;

	public void reloadPresentVerbInTable() throws InvalidFormatException, IOException;

	public void reloadPastVerbInTable() throws InvalidFormatException, IOException;

	public PastParticipleEntity reloadPastParticipleVerbInTable(String pastParticipleVerb)
			throws InvalidFormatException, IOException;

	public void reloadAllExampleVerb() throws IOException, InvalidFormatException;

	public default List<VerbDto> getAllverbForTime(int time) throws InvalidFormatException, IOException {
		OPCPackage file = OPCPackage
				.open(new File(Paths.get("").toAbsolutePath().toString() + ExcelEnglishFileConstant.VERB_FILE));

		XSSFWorkbook excel = new XSSFWorkbook(file);
		XSSFSheet sheet = excel.getSheetAt(ExcelEnglishFileConstant.VERB_SHEET);
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

	public default List<ExampleVerbEntity> getAllExampleVerb() throws InvalidFormatException, IOException {
		OPCPackage file = OPCPackage
				.open(new File(Paths.get("").toAbsolutePath().toString() + ExcelEnglishFileConstant.VERB_FILE));

		XSSFWorkbook excel = new XSSFWorkbook(file);
		XSSFSheet sheet = excel.getSheetAt(ExcelEnglishFileConstant.EXAMPLE_VERB_SHEET);
		Iterator<Row> rowIterator = sheet.iterator();

		Row row;
		List<ExampleVerbEntity> allExample = new ArrayList<>();

		try {

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				if (!row.getCell(1).toString().contains("***")) {

					ExampleVerbEntity example = new ExampleVerbEntity();
					example.setSentence(row.getCell(1).toString());
					example.setHelp(row.getCell(0).toString());
					example.setVerb(row.getCell(2).toString());
					example.setAuxiliaryId(row.getCell(3).toString());

					allExample.add(example);

				}

			}

		} catch (NullPointerException e) {
		}

		return allExample;
	}

}
