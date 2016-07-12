package Untils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {

	public ExcelReader() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 读取表格内容
	 * 
	 * @param assertpath
	 * @author baoer
	 * @return String excel内容
	 */
	public List<Map<String, Object>> readExcelRow(String assertPath) {
		Map<String, Object> result = null;
		List<Map<String, Object>> reslutlist = new ArrayList<Map<String, Object>>();
		try {
			InputStream in = getClass().getResourceAsStream(assertPath);
			Workbook book = Workbook.getWorkbook(in);
			int num = book.getNumberOfSheets();
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			int Rows = sheet.getRows();
			int Cols = sheet.getColumns();
			for (int i = 1; i < Rows; ++i) {
				result = new HashMap<String, Object>();
				for (int j = 0; j < Cols; ++j) {
					// getCell(Col,Row)获得单元格的值
					result.put(sheet.getCell(j, 0).getContents(), sheet.getCell(j, i).getContents());
				}
				reslutlist.add(result);
			}
			book.close();

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reslutlist;
	}

}
