package ie.emeraldjava.poi.racemaster;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Logger;

/**
 * Created by pauloconnell on 14/06/17.
 *
 * http://codebuffs.com/java-read-write-xlsm-using-apache-poi/
 *
 */
public class PoiRaceMaster {

    private static Logger LOG = Logger.getLogger(PoiRaceMaster.class.getName());

    public PoiRaceMaster() {
    }

    public void run() throws Exception {

        LOG.info("PoiRaceMaster");
        // File path which you want to read in this case it is in the resources folder of the project.
        //String fileToRead = "./resources/BHAA.Race.Master.xlsm";
        String fileToRead = "/home/pauloconnell/projects/github/emeraldjava-spring/apache-poi-racemaster/src/main/resources/BHAA.Race.Master.xlsm";

        // We create a new Workbook instance
//        LOG.info(PoiRaceMaster.class.getResource(fileToRead).toURI().toString());

        Workbook workbook = new XSSFWorkbook(OPCPackage.open(fileToRead));
        LOG.info("sheets "+workbook.getNumberOfSheets());


        // Here we do different stuff with workbook (add rows/edit rows/delete rows/add cells/edit cells/delete cells and pretty much anything you can do normally with a workbook using Microsoft Excel.

        // We get a sheet named "Data" inside our workbook
        Sheet sheet = workbook.getSheet("Membership");
        // We create a new row at row number 9 in the sheet
        Row row = sheet.createRow(9);
        // We create a cell at 9th row first column and input some data
        Cell cell = row.createCell(1);
        cell.setCellValue("Data in your cell goes here");

        // Now to save our xlsm file
        String fileToWrite = "/home/pauloconnell/projects/github/emeraldjava-spring/apache-poi-racemaster/src/main/resources/BHAA.Race.Master.Out.xlsm";
        FileOutputStream out = new FileOutputStream(new File(fileToWrite));
        workbook.write(out);
        out.close();
        System.out.println("xlsm created successfully..");
    }

    public static void main(String[] args) {
        try {
            PoiRaceMaster poiRaceMaster = new PoiRaceMaster();
            poiRaceMaster.run();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
