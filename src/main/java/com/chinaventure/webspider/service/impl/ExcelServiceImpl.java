/*package com.chinaventure.webspider.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import com.chinaventure.webspider.model.MediaMonitor;
import com.chinaventure.webspider.service.ExcelService;


@Service
public class ExcelServiceImpl implements ExcelService {

	public static void main(String[] args) {
		new ExcelServiceImpl().parseMediaList(new File("C:\\Users\\Administrator\\Desktop\\媒体列表-0704.xls"));
	}
	
	@Override
	public List<MediaMonitor> parseMediaList(File file){
		List<MediaMonitor> list = new ArrayList<>();
			try {
				POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(file));

				@SuppressWarnings("resource")
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
			    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(14);

			    String sheetName = hssfSheet.getSheetName();
			    String media_group = "";
			    
			    int rowstart = hssfSheet.getFirstRowNum();
			    int rowEnd = hssfSheet.getLastRowNum();
			    for(int i=rowstart;i<rowEnd;i++)
			    {
			        HSSFRow row = hssfSheet.getRow(i);
			        if(null == row) continue;
			        int cellStart = row.getFirstCellNum();
			        int cellEnd = row.getLastCellNum();
			        MediaMonitor stock = new MediaMonitor();
			        stock.setStatus(true);
			        stock.setCreateTime(new Date());
			        stock.setUpdateTime(new Date());
			        stock.setFrequency(1);
			        
			        for(int k=cellStart;k<=cellEnd;k++)
			        {
			            HSSFCell cell = row.getCell(k);
			            if(null==cell) continue;

			           stock.setMonitorGroup(sheetName);
			            switch(k){
			            	case 0:
			            		if(StringUtils.isNotBlank(cell.toString())){
			            			media_group = cell.toString().trim();
			            		}
			            		break;
			            	case 1:
			            		stock.setMonitorName(cell.toString().trim());
			            		break;
			            	case 2:
			            		stock.setUrl(cell.toString().trim());
			            		break;
			            		default:
			            			break;
			            }
			            
			            /*
			            switch (cell.getCellType())
			            {
			                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
			                                System.out.print("数字"
			                            + "   ");
			                    break;
			                case HSSFCell.CELL_TYPE_STRING: // 字符串
			                    System.out.print(cell.getStringCellValue()
			                            + "   ");
			                    break;
			                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
			                    System.out.println(cell.getBooleanCellValue()
			                            + "   ");
			                    break;
			                case HSSFCell.CELL_TYPE_FORMULA: // 公式
			                    System.out.print(cell.getCellFormula() + "   ");
			                    break;
			                case HSSFCell.CELL_TYPE_BLANK: // 空值
			                    System.out.println(" ");
			                    break;
			                case HSSFCell.CELL_TYPE_ERROR: // 故障
			                    System.out.println(" ");
			                    break;
			                default:
			                    System.out.print("未知类型   ");
			                    break;
			            }*/
/*
			        }
			        stock.setMonitorGroup(sheetName);
			        stock.setMediaGroup(media_group);
			        if(StringUtils.isNotBlank(stock.getUrl())){
			        	list.add(stock);
			        }
			    }
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		    return list;
	}

}
*/