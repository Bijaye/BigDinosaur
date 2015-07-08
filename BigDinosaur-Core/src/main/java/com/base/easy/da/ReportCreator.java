package com.base.easy.da;




import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReportCreator
{

            public ReportCreator()
            {
            }

            public byte[] createExcelByList(String functionID, String sheetName, List headerList, List dataList, int columnLength)
            {
   
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet1 = wb.createSheet(sheetName);
    HSSFRow row0 = sheet1.createRow(0);
    HSSFRow row1 = sheet1.createRow(1);
    createTitleLine(wb, row0, sheet1, functionID, columnLength);
    createHeaderLine(wb, headerList, row1, sheet1);
    HSSFCellStyle styleC2 = getBodyStyle(wb);
    for(int i = 0; i < dataList.size(); i++)
    {
        HSSFRow row = sheet1.createRow(i + 2);
        List objList = (List)dataList.get(i);
        int cnt = 0;
        for(int j = 0; j < objList.size(); j++)
        {
            String str = (String)objList.get(j);
            if(cnt < 255)
            {
                HSSFCell cell = row.createCell((short)cnt);
                cell.setCellValue(new HSSFRichTextString(str));
                cell.setCellStyle(styleC2);
                cnt++;
            }
        }

    }

    return getBytes(wb);
}

private HSSFCellStyle getBodyStyle(HSSFWorkbook wb)
{
    HSSFCellStyle styleC2 = wb.createCellStyle();
    styleC2.setBorderRight((short)1);
    styleC2.setBorderLeft((short)1);
    styleC2.setBorderTop((short)1);
    styleC2.setBorderBottom((short)1);
    return styleC2;
}

private void createTitleLine(HSSFWorkbook wb, HSSFRow row0, HSSFSheet sheet1, String functionID, int columnLength)
{
    HSSFCell cell0 = row0.createCell((short)0);
    cell0.setCellValue(new HSSFRichTextString(functionID));
    HSSFCell cell1 = row0.createCell((short)1);
    cell1.setCellValue(new HSSFRichTextString("1"));
    HSSFCell cell2 = row0.createCell((short)2);
    cell2.setCellValue(new HSSFRichTextString("2011111"));
    HSSFCellStyle styleF2 = wb.createCellStyle();
    styleF2.setFillForegroundColor((short)22);
    styleF2.setFillPattern((short)1);
    cell0.setCellStyle(styleF2);
    cell1.setCellStyle(styleF2);
    cell2.setCellStyle(styleF2);
    for(int i = 3; i < columnLength; i++)
        row0.createCell((short)i).setCellStyle(styleF2);

}

private void createHeaderLine(HSSFWorkbook wb, List headerList, HSSFRow row1, HSSFSheet sheet1)
{
    HSSFCellStyle styleF2 = wb.createCellStyle();
    styleF2.setBorderRight((short)1);
    styleF2.setBorderLeft((short)1);
    styleF2.setBorderTop((short)1);
    styleF2.setBorderBottom((short)1);
    for(int i = 0; i < headerList.size(); i++)
    {
        String header = (String)headerList.get(i);
        HSSFCell cell = row1.createCell((short)i);
        cell.setCellValue(new HSSFRichTextString(header));
        cell.setCellStyle(styleF2);
    }

}

public byte[] createExcelByObject(String functionID, String sheetName, List headerList, List dataList, int columnLength)
{
   
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet1 = wb.createSheet(sheetName);
    HSSFRow row0 = sheet1.createRow(0);
    HSSFRow row1 = sheet1.createRow(1);
    createTitleLine(wb, row0, sheet1, functionID, columnLength);
    createHeaderLine(wb, headerList, row1, sheet1);
    HSSFCellStyle styleC2 = getBodyStyle(wb);
    for(int i = 0; i < dataList.size(); i++)
    {
        HSSFRow row = sheet1.createRow(i + 2);
        Object obj = dataList.get(i);
        Method methods[] = obj.getClass().getMethods();
        int cnt = 0;
        for(int j = 0; j < methods.length; j++)
        {
            Method method = methods[j];
            if(method.getName().startsWith("get") && !method.getName().equals("getClass"))
            {
                String str = null;
                try
                {
                    str = method.invoke(obj, new Object[0]).toString();
                }
                catch(IllegalArgumentException e)
                {
                   
                }
                catch(IllegalAccessException e)
                {
                   
                }
                catch(InvocationTargetException e)
                {
                   
                }
                if(cnt < 255)
                {
                    HSSFCell cell = row.createCell((short)cnt);
                    cell.setCellValue(new HSSFRichTextString(str));
                    cell.setCellStyle(styleC2);
                    cnt++;
                }
            }
        }

    }

    return getBytes(wb);
}

private static byte[] getBytes(HSSFWorkbook workBook)
{
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    byte result[] = (byte[])null;
    try
    {
        workBook.write(out);
        result = out.toByteArray();
        out.close();
    }
    catch(IOException e)
    {
       
    }
    return result;
}

public byte[] createExcelByList(String functionID, String screenID, String sheetName, List headerList, List dataList, int columnLength)
{
   
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet1 = wb.createSheet(sheetName);
    HSSFRow row0 = sheet1.createRow(0);
    HSSFRow row1 = sheet1.createRow(1);
    createTitleLine(wb, row0, sheet1, functionID, columnLength);
    createHeaderLine(wb, headerList, row1, sheet1);
    HSSFCellStyle styleC2 = getBodyStyle(wb);
    for(int i = 0; i < dataList.size(); i++)
    {
        HSSFRow row = sheet1.createRow(i + 2);
        List objList = (List)dataList.get(i);
        int cnt = 0;
        for(int j = 0; j < objList.size(); j++)
        {
            String str = (String)objList.get(j);
            if(cnt < 255)
            {
                HSSFCell cell = row.createCell((short)cnt);
                cell.setCellValue(new HSSFRichTextString(str));
                cell.setCellStyle(styleC2);
                cnt++;
            }
        }

    }

    return getBytes(wb);
            }



           
           
}


