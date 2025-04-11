package a100;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Line2 {

	public static void main(String[] args) {
		// category plot ==> bar chart
		// XY plot ==> line chart
		
		// 차트에 들어갈 데이터를 dataset으로 저장
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(100, "kor", "1mon");
		dataset.addValue(50, "kor", "2mon");
		dataset.addValue(80, "kor", "3mon");
		dataset.addValue(70, "kor", "4mon");
		dataset.addValue(60, "kor", "5mon");
		
		// LineChart pc2 = new LineChart(); // render 없이
		// rendering : 프로그램으로 이미지 생성 프로세스
		PlotOrientation po1 = PlotOrientation.VERTICAL; // 수직 그래프
		JFreeChart jfchart = 
				ChartFactory.createLineChart3D
				("국어점수 월별 결과", "wol", "jum", dataset, po1, true, true, true);
				//	title		기준 축   값 축 				범례(가짓수 적으면 안나올 수도 있음)
		// ChartFactory.createLineChart3D(parameters ... )
		// ChartFactory : 다양한 유형의 차트 생성, dataset 사용
		// ChartUtilities 클래스 : 차트를 이미지로 변환하는 
		
		// 한글 깨짐 방지
		jfchart.getTitle().setFont(new Font("굴림", Font.BOLD, 15));
		
		jfchart.setBackgroundPaint(Color.yellow); 
		jfchart.setBorderVisible(true);	// 경계선 보이게
		jfchart.setBorderPaint(Color.PINK); // 경계선 색 지정
		jfchart.setBorderStroke(new BasicStroke(15)); // 경계선 두께(px) 지정
		
		ChartFrame cf2 = new ChartFrame("선 그래프", jfchart); // 창 title
		cf2.pack(); // 자동 크기 조정
		cf2.setSize(1000, 500); // 창 사이즈
		cf2.setVisible(true);
		
	}

}
