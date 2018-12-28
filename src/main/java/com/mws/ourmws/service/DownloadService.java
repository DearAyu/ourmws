package com.mws.ourmws.service;

import com.mws.ourmws.model.SalesOfSku;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class DownloadService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private InventoryService inventoryService;

    /**
     * 创建Excel表格
     * @param response
     * @param name
     * @throws IOException
     */
    public void createExcel(HttpServletResponse response,String name,String accountName) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        String fileName = name + ".xls";
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        if(name.equals("salesOfSku")) {
            String[] headers = {"SKU", "ASIN", "商品名", "近30天销量", "近90天销量", "近180天销量", "近1年销量"};
            //headers表示excel表中第一行的表头
            HSSFRow row = sheet.createRow(0);
            //添加表头
            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
            List<SalesOfSku> salesList = orderService.SalesOfSKU(accountName);
            for (SalesOfSku salesOfSku : salesList) {
                HSSFRow rowContent = sheet.createRow(rowNum);
                rowContent.createCell(0).setCellValue(salesOfSku.getASIN());
                rowContent.createCell(1).setCellValue(salesOfSku.getSellerSKU());
                rowContent.createCell(2).setCellValue(salesOfSku.getTitle());
                rowContent.createCell(3).setCellValue(salesOfSku.getMonthNum());
                rowContent.createCell(4).setCellValue(salesOfSku.getSeasonNum());
                rowContent.createCell(5).setCellValue(salesOfSku.getHalfYearNum());
                rowContent.createCell(6).setCellValue(salesOfSku.getYearNum());
                rowContent.createCell(7).setCellValue(salesOfSku.getInventoryNum());
                rowNum++;
            }
        }else if (name.equals("salesOfSize")){
            String[] headers = {"尺寸", "近30天销量", "近90天销量", "近180天销量", "近1年销量"};
            //headers表示excel表中第一行的表头
            HSSFRow row = sheet.createRow(0);
            //添加表头
            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
            List<SalesOfSku> salesList = orderService.SalesOfSize(accountName);
            for (SalesOfSku salesOfSku : salesList) {
                HSSFRow rowContent = sheet.createRow(rowNum);
                rowContent.createCell(0).setCellValue(salesOfSku.getSize());
                rowContent.createCell(1).setCellValue(salesOfSku.getMonthNum());
                rowContent.createCell(2).setCellValue(salesOfSku.getSeasonNum());
                rowContent.createCell(3).setCellValue(salesOfSku.getHalfYearNum());
                rowContent.createCell(4).setCellValue(salesOfSku.getYearNum());
                rowNum++;
            }
        }else if(name.equals("salesOfColor")){
            String[] headers = {"颜色", "近30天销量", "近90天销量", "近180天销量", "近1年销量"};
            //headers表示excel表中第一行的表头
            HSSFRow row = sheet.createRow(0);
            //添加表头
            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
            List<SalesOfSku> salesList = orderService.SalesOfColor(accountName);
            for (SalesOfSku salesOfSku : salesList) {
                HSSFRow rowContent = sheet.createRow(rowNum);
                rowContent.createCell(0).setCellValue(salesOfSku.getColor());
                rowContent.createCell(1).setCellValue(salesOfSku.getMonthNum());
                rowContent.createCell(2).setCellValue(salesOfSku.getSeasonNum());
                rowContent.createCell(3).setCellValue(salesOfSku.getHalfYearNum());
                rowContent.createCell(4).setCellValue(salesOfSku.getYearNum());
                rowNum++;
            }
        }else if(name.equals("inventoryMsg")){
            String[] headers = {"ASIN", "sellerSKU", "商品名", "库存数"};
            //headers表示excel表中第一行的表头
            HSSFRow row = sheet.createRow(0);
            //添加表头
            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
            List<SalesOfSku> salesList = inventoryService.findInventoryMsg(accountName);
            for (SalesOfSku salesOfSku : salesList) {
                HSSFRow rowContent = sheet.createRow(rowNum);
                rowContent.createCell(0).setCellValue(salesOfSku.getASIN());
                rowContent.createCell(1).setCellValue(salesOfSku.getSellerSKU());
                rowContent.createCell(2).setCellValue(salesOfSku.getTitle());
                rowContent.createCell(3).setCellValue(salesOfSku.getInventoryNum());
                rowNum++;
            }
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

}
