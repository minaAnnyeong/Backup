package a101;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;

public class Pie {

	public static void main(String[] args) {
		// 차트에 들어갈 데이터를 dataset으로 저장
		DefaultPieDataset dataset = new DefaultPieDataset();

		dataset.setValue("kor", 80);
		dataset.setValue("eng", 100);
		dataset.setValue("mat", 50);
		dataset.setValue("music", 70);
		dataset.setValue("art", 100);
		
		PlotOrientation po1 = PlotOrientation.VERTICAL; // 수직 그래프
		JFreeChart jfchart = 
				ChartFactory.createPieChart3D("원 그래프", dataset, true, true, false);
		
		jfchart.setBackgroundPaint(Color.yellow); 
		jfchart.getTitle().setFont(new Font("굴림", Font.BOLD, 15));
		
		ChartFrame cf2 = new ChartFrame("원 그래프", jfchart); // 창 title
		cf2.pack(); // 자동 크기 조정
		cf2.setSize(1000, 500); // 창 사이즈
		cf2.setVisible(true);
	}

}
