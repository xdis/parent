package com.zyxy.common.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.zyxy.common.enums.LitigantUserTypeEnum;
import com.zyxy.common.vo.doc.CaseDocAgentVO;
import com.zyxy.common.vo.doc.CaseDocHeadVO;
import com.zyxy.common.vo.doc.CaseDocLitigantVO;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * PDF 工具类
 * @author tanquan
 *
 */
public class PDFUtil {

	private final static Logger logger = LoggerFactory.getLogger(PDFUtil.class);

	public static final String ST_FONT_CH_FILE = "simsun.ttc"; // 宋体
	public static final String FS_FONT_CH_FILE = "simfang.ttf"; // 仿宋

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

	public static final Rectangle PAGE_SIZE = PageSize.A4;
	public static final float MARGIN_LEFT = 72;
	public static final float MARGIN_RIGHT = 72;
	public static final float MARGIN_TOP = 80;
	public static final float MARGIN_BOTTOM = 70;
	public static final float SPACING = 20;

	private Document document = null;

	public Document getDocument() {
		return document;
	}

    public ByteArrayOutputStream getOut() {
        return out;
    }

	/**
	 * 功能：创建导出数据的目标文档
     *
	 *
	 * @return  存储文件的临时路径
	 */
    public void createDocument() {
        document = new Document(PAGE_SIZE, MARGIN_LEFT, MARGIN_RIGHT,
				MARGIN_TOP, MARGIN_BOTTOM);
		try {
			PdfWriter.getInstance(document, out);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 打开文档准备写入内容
		document.open();
	}


	/**
	 * 功能：创建导出数据的目标文档(自定义文档大小)
	 *
	 * @param fileName
	 *            存储文件的临时路径
	 * @return
	 */
	public void createDocument(String fileName,Rectangle pageSize,float marginLeft,float marginRight,float marginTop,float marginBottom) {
		File file = new File(fileName);
		FileOutputStream out = null;
		document = new Document(pageSize, marginLeft, marginRight,
				marginTop, marginBottom);
		try {
			out = new FileOutputStream(file);
			// PdfWriter writer =
			PdfWriter.getInstance(document, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 打开文档准备写入内容
		document.open();
	}

	/**
	 * 将段落写入到指定的PDF文档中（居中方式）
	 * @param text
	 * @param font
	 */
	public PDFUtil writeParagraphToDocAligment(String text, Font font){

		Paragraph paragraph = new Paragraph(text,font);
		paragraph.setAlignment(1);
		try {
			if(document!=null){
				if(!document.isOpen()){
					document.open();
				}
				document.add(paragraph);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
        return this;
    }
	/**
	 * 将段落写入到指定的PDF文档中（右对齐）
	 * @param text
	 * @param font
	 */
	public void writeParagraphToDocAligmentRight(String text, Font font){

		Paragraph paragraph = new Paragraph(text,font);
		paragraph.setAlignment(2);
		try {
			if(document!=null){
				if(!document.isOpen()){
					document.open();
				}
				document.add(paragraph);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}


	/**
	 * 将段落写入到指定的PDF文档中（缩进）
	 * @param text
	 * @param font
	 */
    public PDFUtil writeParagraphToDocIndent(String text, Font font) {

		Paragraph paragraph = new Paragraph(text,font);
		paragraph.setAlignment(Element.ALIGN_LEFT);
		paragraph.setFirstLineIndent(font.getSize()*2);
		try {
			if(document!=null){
				if(!document.isOpen()){
					document.open();
				}
				document.add(paragraph);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

        return this;
    }


	/**
	 * 将段落写入到指定的PDF文档中
	 * @param text
	 * @param font
	 */
	public void writeParagraphToDoc(String text, Font font){

		Paragraph paragraph = new Paragraph(text,font);
		try {
			if(document!=null){
				if(!document.isOpen()){
					document.open();
				}
				document.add(paragraph);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 将段落写入到指定的PDF文档中（缩进指定大小）
	 * @param text
	 * @param font
	 */
	public void writeParagraphToDocIndent(String text, Font font,float size){

		Paragraph paragraph = new Paragraph(text,font);
		paragraph.setAlignment(Element.ALIGN_LEFT);
		paragraph.setFirstLineIndent(size);
		try {
			if(document!=null){
				if(!document.isOpen()){
					document.open();
				}
				document.add(paragraph);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}


	/**
	 * 换行
	 */
	public void writeBr(){
		Chunk br = new Chunk("\n");	//换行
		try {
			document.add(br);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将章节写入到指定的PDF文档中
     *
     * @param chapter
	 * @return
	 */
	public void writeChapterToDoc(Chapter chapter) {
		try {
			if (document != null) {
				if (!document.isOpen()) {
					document.open();
				}
				document.add(chapter);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 功能 创建PDF文档中的章节
     *
     * @param title
	 *            章节标题
	 * @param chapterNum
	 *            章节序列号
	 * @param alignment
	 *            0表示align=left，1表示align=center
	 * @param numberDepth
	 *            章节是否带序号 设值=1 表示带序号 1.章节一；1.1小节一...，设值=0表示不带序号
	 * @param font
	 *            字体格式
	 * @return Chapter章节
	 */
	public static Chapter createChapter(String title, int chapterNum,
			int alignment, int numberDepth, Font font) {
		Paragraph chapterTitle = new Paragraph(title, font);
		chapterTitle.setAlignment(alignment);
		Chapter chapter = new Chapter(chapterTitle, chapterNum);
		chapter.setNumberDepth(numberDepth);
		return chapter;
	}

	/**
	 * 功能：创建某指定章节下的小节
     *
     * @param chapter
	 *            指定章节
	 * @param title
	 *            小节标题
	 * @param font
	 *            字体格式
	 * @param numberDepth
	 *            小节是否带序号 设值=1 表示带序号 1.章节一；1.1小节一...，设值=0表示不带序号
	 * @return section在指定章节后追加小节
	 */
	public static Section createSection(Chapter chapter, String title,
			Font font, int numberDepth) {
		Section section = null;
		if (chapter != null) {
			Paragraph sectionTitle = new Paragraph(title, font);
			sectionTitle.setSpacingBefore(SPACING);
			section = chapter.addSection(sectionTitle);
			section.setNumberDepth(numberDepth);
		}
		return section;
	}

	/**
	 * 功能：向PDF文档中添加的内容
     *
     * @param text
	 *            内容
	 * @param font
	 *            内容对应的字体
	 * @return phrase 指定字体格式的内容
	 */
	public static Phrase createPhrase(String text, Font font) {
		Phrase phrase = new Paragraph(text, font);
		return phrase;
	}

	/**
	 * 功能：创建列表
     *
     * @param numbered
	 *            设置为 true 表明想创建一个进行编号的列表
	 * @param lettered
	 *            设置为true表示列表采用字母进行编号，为false则用数字进行编号
	 * @param symbolIndent
	 * @return list
	 */
	public static List createList(boolean numbered, boolean lettered,
			float symbolIndent) {
		List list = new List(numbered, lettered, symbolIndent);
		return list;
	}

	/**
	 * 功能：创建列表中的项
     *
     * @param content
	 *            列表项中的内容
	 * @param font
	 *            字体格式
	 * @return listItem
	 */
	public static ListItem createListItem(String content, Font font) {
		ListItem listItem = new ListItem(content, font);
		return listItem;
	}

	/**
	 * 功能：创造字体格式
     *
     * @param fontname
	 * @param size
	 *            字体大小
	 * @param style
	 *            字体风格
	 * @param color
	 *            字体颜色
	 * @return Font
	 */
	public static Font createFont(String fontname, float size, int style,
			BaseColor color) {
		Font font = FontFactory.getFont(fontname, size, style, color);
		return font;
	}

	/**
	 * 功能： 返回支持宋体的字体
     *
     * @param size
	 *            字体大小
	 * @param style
	 *            字体风格
	 * @return 字体格式
	 */
	public static Font createSTFont(float size, int style) {
		BaseFont bfChinese = null;
		try {
			bfChinese = BaseFont.createFont(getChineseFont("simsun.ttc")+",1",
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Font(bfChinese, size, style);
	}

	/**
	 * 功能： 返回支持仿宋的字体
	 *
	 * @param size
	 *            字体大小
	 * @param style
	 *            字体风格
	 * @return 字体格式
	 */
	public static Font createFSFont(float size, int style) {
		BaseFont bfChinese = null;
		try {
			bfChinese = BaseFont.createFont(getChineseFont("simfang.ttf"),
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Font(bfChinese, size, style);
	}




	/**
	 * 最后关闭PDF文档
	 */
	public void closeDocument() {
		if (document != null) {
			document.close();
		}
	}

    /**
     * 最后关闭PDF文档
     */
    public void closeOut() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


	/**
	 * 查找系统字体
	 * @param font
	 * @return
	 */
	private static String getChineseFont(String font){


		//宋体（对应css中的 属性 font-family: SimSun; /*宋体*/）
		String font1 ="C:/Windows/Fonts/"+font;


		//判断系统类型，加载字体文件
		java.util.Properties prop = System.getProperties();
		String osName = prop.getProperty("os.name").toLowerCase();
		if (osName.indexOf("linux")>-1) {
			font1="/usr/share/fonts/"+font;
		}
		if(!new File(font1).exists()){
			throw new RuntimeException("字体文件不存在,影响导出pdf中文显示！"+font1);
		}
		return font1;
	}
	/**
	 * 读PDF文件，使用了pdfbox开源项目
     *
     * @param fileName
	 */
    public String readPDFAsStr(String fileName) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            // 新建一个PDF解析器对象   
            PDFParser parser = new PDFParser(in);
            // 对PDF文件进行解析   
            parser.parse();
            // 获取解析后得到的PDF文档对象   
            PDDocument pdfdocument = parser.getPDDocument();
            // 新建一个PDF文本剥离器   
            PDFTextStripper stripper = new PDFTextStripper();
            // 从PDF文档对象中剥离文本   
            return stripper.getText(pdfdocument);
        } catch (Exception e) {
            logger.error("read pdf[{}] error", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("close inputstream error", e);
                }
            }
        }
        return null;
	}

	public static void main(String[] args) {
        String fileName = "D:\\test11.pdf";  //这里先手动把绝对路径的文件夹给补上。
        PDFUtil pdfUtil = new PDFUtil();

        Font chapterFont = PDFUtil.createSTFont(20, Font.BOLD);//文章标题字体
        Font sectionFont = PDFUtil.createSTFont(16, Font.BOLD);//文章小节字体
        Font textFont = PDFUtil.createSTFont(10, Font.NORMAL);//小节内容字体

        pdfUtil.createDocument();
        Chapter chapter = PDFUtil.createChapter("糖尿病病例1", 1, 1, 0, chapterFont);
        Section section1 = PDFUtil.createSection(chapter, "病例联系人信息", sectionFont, 0);
        Phrase text1 = PDFUtil.createPhrase("如您手中有同类现成病例，在填写完以上基础信息后，传病例附件", textFont);
        section1.add(text1);

        Section section2 = PDFUtil.createSection(chapter, "病例个人体会", sectionFont, 0);
        Phrase text2 = PDFUtil.createPhrase("1.下载病例生成PDF文档", textFont);
//      text2.setFirstLineIndent(20);  //第一行空格距离  
        section2.add(text1);
        section2.add(text2);

        List list = PDFUtil.createList(true, false, 20);
        String tmp = "还有什么能够文档。文档是 PDF 文档的所有元素的容器。 ";
        ListItem listItem1 = PDFUtil.createListItem(tmp, textFont);
        ListItem listItem2 = PDFUtil.createListItem("列表2", textFont);
        list.add(listItem1);
        list.add(listItem2);
        section2.add(list);

        pdfUtil.writeChapterToDoc(chapter);
        pdfUtil.closeDocument();
        pdfUtil.closeOut();
        pdfUtil.readPDFAsStr("D:\\test11.pdf");
	}

    /**
     * 生成申请人、被申请人信息
     *
     * @param caseDocHead 头部
     * @return
     */
    public boolean writeLitigantInfo(CaseDocHeadVO caseDocHead) {
        try {
            BaseFont bfFs = BaseFont.createFont(getChineseFont(FS_FONT_CH_FILE), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            //正文字体
            Font fsFont = new Font(bfFs, 16, Font.NORMAL);

            //申请人信息
            CaseDocLitigantVO applicant = caseDocHead.getApplicant();
            writeApplicant(fsFont, applicant);

            //被申请人信息
            CaseDocLitigantVO beApplicant = caseDocHead.getApplicant();
            writeBeApplicant(fsFont, beApplicant);

        } catch (Exception e) {
            logger.error("生成文书失败");
            return false;
        }
        return true;
    }

    /**
     * 生成申请人、被申请人、申请人代理、被申请人代理信息
     *
     * @param caseDocHead 头部
     * @return
     */
    public boolean writeLitigantAndAgentInfo(CaseDocHeadVO caseDocHead) {
        try {
            BaseFont bfFs = BaseFont.createFont(getChineseFont(FS_FONT_CH_FILE), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            //正文字体
            Font fsFont = new Font(bfFs, 16, Font.NORMAL);

            //申请人信息
            CaseDocLitigantVO applicant = caseDocHead.getApplicant();
            writeApplicant(fsFont, applicant);

            //申请人代理
            CaseDocAgentVO applicantAgent = caseDocHead.getApplicantAgent();
            writeAgent(fsFont, applicantAgent, "代理人");

            //被申请人信息
            CaseDocLitigantVO beApplicant = caseDocHead.getApplicant();
            writeBeApplicant(fsFont, beApplicant);

            //被申请人代理
            CaseDocAgentVO beApplicantAgent = caseDocHead.getBeApplicantAgent();
            writeAgent(beApplicantAgent);

        } catch (Exception e) {
            logger.error("生成文书失败");
            return false;
        }
        return true;
    }

    /**
     * 写入申请人信息
     *
     * @param applicant 当事人信息
     */
    public void writeApplicant(CaseDocLitigantVO applicant) throws DocumentException, IOException {
        writeApplicant(applicant, "申请人");
    }

    /**
     * 写入申请人信息
     *
     * @param applicant 当事人信息
     * @param head      前置名称
     */
    public void writeApplicant(CaseDocLitigantVO applicant, String head) throws DocumentException, IOException {
        BaseFont bfFs = BaseFont.createFont(getChineseFont(FS_FONT_CH_FILE), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //正文字体
        Font fsFont = new Font(bfFs, 16, Font.NORMAL);
        writeLitigant(fsFont, applicant, head);
    }

    /**
     * 写入申请人信息
     *
     * @param fsFont    字体
     * @param applicant 当事人信息
     */
    private void writeApplicant(Font fsFont, CaseDocLitigantVO applicant) throws DocumentException {
        writeApplicant(fsFont, applicant, "申请人");
    }

    /**
     * 写入申请人信息
     *
     * @param fsFont    字体
     * @param applicant 当事人信息
     * @param head      前置名称
     */
    private void writeApplicant(Font fsFont, CaseDocLitigantVO applicant, String head) throws DocumentException {
        writeLitigant(fsFont, applicant, head);
    }

    /**
     * 写入被申请人信息
     *
     * @param applicant 当事人信息
     */
    public void writeBeApplicant(CaseDocLitigantVO applicant) throws DocumentException, IOException {
        writeBeApplicant(applicant, "被申请人");
    }

    /**
     * 写入被申请人信息
     *
     * @param applicant 当事人信息
     * @param head      前置名称
     */
    public void writeBeApplicant(CaseDocLitigantVO applicant, String head) throws DocumentException, IOException {
        BaseFont bfFs = BaseFont.createFont(getChineseFont(FS_FONT_CH_FILE), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //正文字体
        Font fsFont = new Font(bfFs, 16, Font.NORMAL);
        writeBeApplicant(fsFont, applicant, head);
    }

    /**
     * 写入被申请人信息
     *
     * @param fsFont    字体
     * @param applicant 当事人信息
     */
    private void writeBeApplicant(Font fsFont, CaseDocLitigantVO applicant) throws DocumentException {
        writeBeApplicant(fsFont, applicant, "被申请人");
    }

    /**
     * 写入被申请人信息
     *
     * @param fsFont    字体
     * @param applicant 当事人信息
     * @param head      前置名称
     */
    private void writeBeApplicant(Font fsFont, CaseDocLitigantVO applicant, String head) throws DocumentException {
        writeLitigant(fsFont, applicant, head);
    }

    /**
     * 写入当事人信息
     *
     * @param fsFont    字体
     * @param applicant 当事人信息
     * @param head      前置名称
     */
    private void writeLitigant(Font fsFont, CaseDocLitigantVO applicant, String head) throws DocumentException {
        if (applicant != null) {
            if (LitigantUserTypeEnum.PROPESER.getValue().equals(applicant.getType())) {
                /*
                    申请人：姓名，性别，民族，xx年xx月xx日出生，身份证号码：xxx
                    住所：xxx
                * */
                //申请人为自然人
                Map<String, String> birthday = getBirthday(applicant.getBirthday());
                Paragraph proposerPh = new Paragraph(head + "：" + applicant.getName() + "，" + applicant.getSex() + "，" + applicant.getEthnic() + "，" + birthday.get("y") + "年" + birthday.get("m") + "月" + birthday.get("d") + "日出生，身份证号码：" + applicant.getCardId(), fsFont);
                proposerPh.setFirstLineIndent(32);
                proposerPh.setAlignment(Element.ALIGN_LEFT);
                document.add(proposerPh);
                proposerPh = new Paragraph("住所：" + applicant.getAddress(), fsFont);
                proposerPh.setFirstLineIndent(32);
                proposerPh.setAlignment(Element.ALIGN_LEFT);
                document.add(proposerPh);
            } else {
                /*
                    申请人：单位名称
                    住所：xxx
                    法定代表人：姓名，职务：xxx
                * */
                Paragraph proposerPh = new Paragraph(head + "：" + applicant.getName(), fsFont);
                proposerPh.setFirstLineIndent(32);
                proposerPh.setAlignment(Element.ALIGN_LEFT);
                document.add(proposerPh);
                proposerPh = new Paragraph("住所：" + applicant.getAddress(), fsFont);
                proposerPh.setFirstLineIndent(32);
                proposerPh.setAlignment(Element.ALIGN_LEFT);
                document.add(proposerPh);
                proposerPh = new Paragraph("法定代表人：" + applicant.getCertDuties() + "，职务：" + applicant.getCertDuties(), fsFont);
                proposerPh.setFirstLineIndent(32);
                proposerPh.setAlignment(Element.ALIGN_LEFT);
                document.add(proposerPh);
            }
        }
    }

    /**
     * 写入代理人信息
     *
     * @param agent 代理人信息
     */
    public void writeAgent(CaseDocAgentVO agent) throws DocumentException, IOException {
        writeAgent(agent, "代理人");
    }

    /**
     * 写入代理人信息
     *
     * @param agent 代理人信息
     * @param head  前置名称
     */
    public void writeAgent(CaseDocAgentVO agent, String head) throws DocumentException, IOException {
        BaseFont bfFs = BaseFont.createFont(getChineseFont(FS_FONT_CH_FILE), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //正文字体
        Font fsFont = new Font(bfFs, 16, Font.NORMAL);
        writeAgent(fsFont, agent, head);
    }

    /**
     * 写入代理人信息
     *
     * @param fsFont 字体
     * @param agent  代理人信息
     * @param head   前置名称
     * @throws DocumentException
     */
    public void writeAgent(Font fsFont, CaseDocAgentVO agent, String head) throws DocumentException {
        if (agent != null) {
            //自然人
            if ("0".equals(agent.getType())) {
                /*
                    代理人：姓名，性别，民族，xx年xx月xx日出生，身份证号码：xxx
                    住所：xxx
                * */
                //申请人为自然人
                Map<String, String> birthday = getBirthday(agent.getBirthday());
                Paragraph proposerPh = new Paragraph(head + "：" + agent.getName() + "，性别，" + agent.getSex() + "，" + birthday.get("y") + "年" + birthday.get("m") + "月" + birthday.get("d") + "xx月xx日出生，身份证号码：" + agent.getCardId(), fsFont);
                proposerPh.setFirstLineIndent(32);
                proposerPh.setAlignment(Element.ALIGN_LEFT);
                document.add(proposerPh);
                proposerPh = new Paragraph("住所：" + agent.getAddress(), fsFont);
                proposerPh.setFirstLineIndent(32);
                proposerPh.setAlignment(Element.ALIGN_LEFT);
                document.add(proposerPh);
            } else {
                /*
                    代理人：姓名，xx律师事务所律师
                * */
                Paragraph proposerPh = new Paragraph(head + "：" + agent.getName() + "，" + agent.getDuties(), fsFont);
                proposerPh.setFirstLineIndent(32);
                proposerPh.setAlignment(Element.ALIGN_LEFT);
                document.add(proposerPh);
            }
        }
    }

    private Map<String, String> getBirthday(String birthday) {
        Map<String, String> result = new HashMap<>(3, 1);
        result.put("y", birthday.substring(0, 4));
        result.put("m", birthday.substring(4, 6));
        result.put("d", birthday.substring(6, 8));
        return result;
    }


	/**
	 * 根据小写数字格式的日期转换成大写格式的日期
	 * @param date
	 * @return
	 */
	public static String getUpperDate(String date) {
		char[] upper = "〇一二三四五六七八九十".toCharArray();
		if(date == null) return null;
		//非数字的都去掉
		date = date.replaceAll("\\D", "");
		if(date.length() != 8) return null;
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<4;i++) {//年
			sb.append(upper[Integer.parseInt(date.substring(i, i+1))]);
		}
		sb.append("年");//拼接年
		int month = Integer.parseInt(date.substring(4, 6));
		if(month <= 10) {
			sb.append(upper[month]);
		} else {
			sb.append("十").append(upper[month%10]);
		}
		sb.append("月");//拼接月

		int day = Integer.parseInt(date.substring(6));
		if (day <= 10) {
			sb.append(upper[day]);
		} else if(day < 20) {
			sb.append("十").append(upper[day % 10]);
		} else {
			sb.append(upper[day / 10]).append("十");
			int tmp = day % 10;
			if (tmp != 0) sb.append(upper[tmp]);
		}
		sb.append("日");//拼接日
		return sb.toString();
	}



	/**
	 * 根据小写数字格式的日期转换成大写格式的日期
	 * @param date
	 * @return
	 */
	public static String getUpperDate(Date date) {

		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=simpleDateFormat.format(date);
		char[] upper = "〇一二三四五六七八九十".toCharArray();
		if(dateStr == null) {
			return null;
		}
		//非数字的都去掉
		dateStr = dateStr.replaceAll("\\D", "");
		if(dateStr.length() != 8) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<4;i++) {//年
			sb.append(upper[Integer.parseInt(dateStr.substring(i, i+1))]);
		}
		sb.append("年");//拼接年
		int month = Integer.parseInt(dateStr.substring(4, 6));
		if(month <= 10) {
			sb.append(upper[month]);
		} else {
			sb.append("十").append(upper[month%10]);
		}
		sb.append("月");//拼接月

		int day = Integer.parseInt(dateStr.substring(6));
		if (day <= 10) {
			sb.append(upper[day]);
		} else if(day < 20) {
			sb.append("十").append(upper[day % 10]);
		} else {
			sb.append(upper[day / 10]).append("十");
			int tmp = day % 10;
			if (tmp != 0) sb.append(upper[tmp]);
		}
		sb.append("日");//拼接日
		return sb.toString();
	}


	public static String[] generateHtmlToStr(String content){
		content = content.replaceAll("</p>", "\n")
				.replaceAll("<br/>", "\n")
				.replaceAll("<br />", "\n")
				.replaceAll("<br>", "\n")
				.replaceAll("&nbsp;", "  ")
				.replaceAll("<[^>]*>|<\\/[^>]*>", "");
		return content.split("\n");
	}

	public void writeStringStrs(String content,Font font){
		String[] contents=generateHtmlToStr(content);

		for (String str:contents){

			Paragraph paragraph = new Paragraph(str,font);
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.setFirstLineIndent(font.getSize()*2);
			try {
				if(document!=null){
					if(!document.isOpen()){
						document.open();
					}
					document.add(paragraph);
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}

		}

	}

    public PDFUtil writeStringStrs(String content, Font font, int alignment) {
        String[] contents = generateHtmlToStr(content);

        for (String str : contents) {

            Paragraph paragraph = new Paragraph(str, font);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setFirstLineIndent(font.getSize() * 2);
            try {
                if (document != null) {
                    if (!document.isOpen()) {
                        document.open();
                    }
                    document.add(paragraph);
                }
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        }
        return this;

    }

    public PDFUtil writeDateToDoc(Font font) {
        writeStringStrs(getUpperDate(new Date()), font, Element.ALIGN_RIGHT);
        return this;
    }
}
