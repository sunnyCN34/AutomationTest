package utilities;

        import java.io.FileInputStream;

		import java.io.FileNotFoundException;

	

		import java.io.IOException;

		import org.apache.poi.xssf.usermodel.XSSFCell;

		

		import org.apache.poi.xssf.usermodel.XSSFSheet;

		import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class ExcelUtils {

			private static XSSFSheet sheet;

			private static XSSFWorkbook workBook;

			private static XSSFCell Cell;

			

		public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

		   String[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);

			   // Access the required test data sheet

			   workBook = new XSSFWorkbook(ExcelFile);

			   sheet = workBook.getSheet(SheetName);

			   int irow = 1;

			   int icolumn = 1;

			   int x,y;

			   int totalRows = sheet.getLastRowNum();
                              
			   int totalCols = sheet.getRow(0).getLastCellNum()-1;

			   tabArray=new String[totalRows][totalCols];

			   x=0;

			   for (int i=irow;i<=totalRows;i++, x++) {           	   

				  y=0;

				   for (int j=icolumn;j<=totalCols;j++, y++){

					   tabArray[x][y]=getCellData(i,j);

					   System.out.println(tabArray[x][y]);  

						}

					}

				}

			catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}

		public static String getCellData(int RowNum, int ColNum) {

				Cell = sheet.getRow(RowNum).getCell(ColNum);

					String CellData = Cell.getStringCellValue();

					return CellData;

						

			}
	}