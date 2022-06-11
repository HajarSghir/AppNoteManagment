package com.gsnotes.services.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Utilisateur;
import com.gsnotes.bo.Element;
import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Module;
import com.gsnotes.dao.IElementDao;
import com.gsnotes.dao.IEtudiantDao;
import com.gsnotes.dao.IInscriptionAnnuelleDao;
import com.gsnotes.dao.IModuleDao;
import com.gsnotes.dao.IUtilisateurDao;
import com.gsnotes.services.IElementService;
import com.gsnotes.services.IModuleService;

@Service
@Transactional
public class ModuleServiceImpl implements IModuleService {
    @Autowired
    public IModuleDao moduleDao;
    @Autowired
    public IInscriptionAnnuelleDao inscriptionDao;
    @Autowired
	private IElementDao elementDao;
    @Autowired
	private IElementService elementService;
    @Autowired
	private IEtudiantDao etuDao;
    @Autowired
    private InscriptionAnnuelleServiceImpl inscriptionService ;
	@Override
	public List<Module> getAllModule() {
		return moduleDao.findAll();
	}

	@Override
	public List<Module> listModuleByNiveau(Niveau n) {
		List<Module> modules=moduleDao.findAllByNiveau(n);
		return modules;
	}

	@Override
	public Module getModuleById(Long id) {
		Module m = moduleDao.getById(id);
		return m;
	}

	@Override
	public List<Element> listElements(Module m) {
		List<Element> elements=elementDao.findAllByModule(m);
		return elements;
	}

	@Override
	public HSSFWorkbook prepareExport(Module m,String s) throws NumberFormatException{
		    List<Etudiant> liste =inscriptionService.getListEtudiantByNiveau(m.getNiveau()); 
		    HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet =  workbook.createSheet("test");
	        FormulaEvaluator formulaEval = workbook.getCreationHelper().createFormulaEvaluator();
	        Calendar calendar = Calendar.getInstance();
	        Cell cellule,cellule2,cellule3,cellule4,cellule5,cellule6,cellule7,cellule8;
	        Row row ;
	        
	        
	        HSSFCellStyle style = workbook.createCellStyle();
	        style.setBorderTop(BorderStyle.THIN);
	        style.setBorderBottom(BorderStyle.THIN);
	        style.setBorderRight(BorderStyle.THIN);
	        style.setBorderLeft(BorderStyle.THIN);
	        style.setFillForegroundColor(
	                HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        sheet.setDefaultColumnWidth(20);
	        
	        HSSFFont font = workbook.createFont();
	        font.setFontName(HSSFFont.FONT_ARIAL);
	        font.setFontHeightInPoints((short) 10);
	        font.setBold(true);
	        font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
	        style.setFont(font);
	        
	        HSSFCellStyle stylecell = workbook.createCellStyle();
	        stylecell.setBorderTop(BorderStyle.THIN);
	        stylecell.setBorderBottom(BorderStyle.THIN);
	        stylecell.setBorderRight(BorderStyle.THIN);
	        stylecell.setBorderLeft(BorderStyle.THIN);
	        
	        HSSFFont fontCell = workbook.createFont();
	        fontCell.setFontName(HSSFFont.FONT_ARIAL);
	        fontCell.setFontHeightInPoints((short) 10);
	        fontCell.setBold(true);
	        fontCell.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
	        stylecell.setFont(fontCell);
	        
	        
	        Row header = sheet.createRow(0);
	        header.setHeight((short)900);
	        Cell cell = header.createCell(0);
	        cell.setCellStyle(style);
	        Cell cell1 = header.createCell(1);
	        cell1.setCellStyle(stylecell);
	        Cell cell2 = header.createCell(2);
	        cell2.setCellStyle(style);
	        Cell cell3 = header.createCell(3);
	        cell3.setCellStyle(stylecell);
	        Cell cell4 = header.createCell(4);
	        cell4.setCellStyle(style);
	        Cell cell5 = header.createCell(5);
	        cell5.setCellStyle(stylecell);
	        
	        
	        
	        cell.setCellValue("Module"); 
	        cell1.setCellValue(m.getTitre());
	        cell2.setCellValue("Semestre");
	        if ( calendar.get( Calendar.MONTH )<=Calendar.FEBRUARY && calendar.get( Calendar.MONTH )>=Calendar.SEPTEMBER  ) { 
	        cell3.setCellValue("Automne");
	         }else {
	        cell3.setCellValue("Printemps");
	         }
	        cell4.setCellValue("Année");
	        InscriptionAnnuelle AI = inscriptionService.getInscriptionByEtudiant(liste.get(0));
	        System.out.println(AI.getAnnee());
	        int a = AI.getAnnee();
	        cell5.setCellValue(a+"/"+(a+1));
	        
	        Row header2 =sheet.createRow(1);
	        header2.setHeight((short)900);
	        cellule =header2.createCell(0);
	        cellule.setCellStyle(style);
	        cellule.setCellValue("Enseignant");
        	cellule2=header2.createCell(1);
        	cellule2.setCellStyle(stylecell);
        	cellule2.setCellValue(m.getEnseignant().getNom());
        	cellule3=header2.createCell(2);
        	cellule3.setCellStyle(style);
        	cellule3.setCellValue("Session");
        	cellule4=header2.createCell(3);
        	cellule4.setCellStyle(stylecell);
        	cellule4.setCellValue(s);
        	cellule5=header2.createCell(4);
        	cellule5.setCellStyle(style);
        	cellule5.setCellValue("Classe");
        	cellule6=header2.createCell(5);
        	cellule6.setCellStyle(stylecell);
        	cellule6.setCellValue(m.getNiveau().getTitre());
        	
        	
        	
        	
	        row =sheet.createRow(3);
	        row.setRowStyle(stylecell);
	        cellule =row.createCell(0);
	        cellule.setCellStyle(stylecell);
	        cellule.setCellValue("ID Etudiant");
        	cellule2=row.createCell(1);
        	cellule2.setCellStyle(stylecell);
        	cellule2.setCellValue("CNE");
        	cellule3=row.createCell(2);
        	cellule3.setCellStyle(stylecell);
        	cellule3.setCellValue("NOM");
        	cellule4=row.createCell(3);
        	cellule4.setCellStyle(stylecell);
        	cellule4.setCellValue("PRENOM");
        	
        	List<Element> elements = elementDao.findAllByModule(m);
        	if(elements.size()==2) {
        		
        		cellule5=row.createCell(4);
        		cellule5.setCellStyle(stylecell);
            	cellule6=row.createCell(5);
            	cellule6.setCellStyle(stylecell);
            	cellule7=row.createCell(6);
            	cellule7.setCellStyle(stylecell);
            	cellule8=row.createCell(7);
            	cellule8.setCellStyle(stylecell);
        		cellule5.setCellValue(elements.get(0).getNom());
        		cellule6.setCellValue(elements.get(1).getNom());
        		cellule7.setCellValue("Moyenne");
        		cellule8.setCellValue("Validation");
        		
        	}else {
        		cellule5=row.createCell(4);
        		cellule5.setCellStyle(stylecell);
        		cellule5.setCellValue(m.getTitre());
        		cellule6=row.createCell(5);
        		cellule6.setCellStyle(stylecell);
        		cellule6.setCellValue("Moyenne");
        		cellule7=row.createCell(6);
        		cellule7.setCellStyle(stylecell);
        		cellule7.setCellValue("Validation");
        	}
        	
        	
        	
        	
        	int i = 4 ;
	        for(Etudiant e : liste) {
	        	HSSFCellStyle styleC = workbook.createCellStyle();
	        	styleC.setBorderTop(BorderStyle.THIN);
	 	        styleC.setBorderBottom(BorderStyle.THIN);
	 	        styleC.setBorderRight(BorderStyle.THIN);
	 	        styleC.setBorderLeft(BorderStyle.THIN);
	        	row =sheet.createRow(i++);
	        	row.setRowStyle(styleC);
	        	cellule =row.createCell(0);
	        	cellule.setCellStyle(styleC);
	        	cellule.setCellValue(e.getIdUtilisateur());
	        	cellule2=row.createCell(1);
	        	cellule2.setCellStyle(styleC);
	        	cellule2.setCellValue(e.getCne());
	        	cellule3=row.createCell(2);
	        	cellule3.setCellStyle(styleC);
	        	cellule3.setCellValue(e.getNom());
	        	cellule4=row.createCell(3);
	        	cellule4.setCellStyle(styleC);
	        	cellule4.setCellValue(e.getPrenom());
	        	if(elements.size()==2 ) {
	        		cellule5= row.createCell(6);
	        		cellule5.setCellStyle(styleC);
		        	String E="E"+i+"*0.5";
		        	String F="F"+i+"*0.5";
		        	String G="G"+i;
		        	String f="SUM("+E+","+F+")";
		        	cellule5.setCellFormula(f);
		        	cellule6=row.createCell(7);
		        	cellule6.setCellStyle(styleC);
		        	CellValue cellValue = formulaEval.evaluate(cellule5);
		        	System.out.println(cellValue.getNumberValue());
		        	System.out.println("salam"+cellule5.getNumericCellValue()); 
		        	if( s.equals("Normale")) {	
		        		cellule6.setCellFormula("IF("+G+">=12,\"V\",\"R\")");
		        	}else {
			        	cellule6.setCellFormula("IF("+G+"<8,\"V\",\"R\")");
		        	}
	        			       	
		        }else{
		        	cellule5= row.createCell(5);
		        	cellule5.setCellStyle(styleC);
		        	cellule5.setCellFormula("E"+i);
		        	String F="F"+i;
		        	cellule6=row.createCell(6);
		        	cellule6.setCellStyle(styleC);
		        	if(s.equals("Normale")) {
		        		cellule6.setCellFormula("IF("+F+">=12,\"V\",\"R\")");
			       
		        	}else {
		        		cellule6.setCellFormula("IF("+F+"<8,\"V\",\"R\")");
		        	}
		        	
	              }
	            }
	        
	        liste.forEach(e->{
				 System.out.println(e.getNom()+" "+e.getPrenom()); 
			 });
	        // CellStyle cellStyle = cell.getCellStyle();
	        //cellStyle.setFillBackgroundColor(IndexedColors.BLACK.index);
	        System.out.println("Excel written successfully"); 
	        return workbook ;
	        
	}

}









