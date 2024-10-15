import java.util.Comparator;

import core.AbstractSortingAlgorithm;
import core.AbstractSwappingSortingAlgorithm;
import testing.*;
import testing.comparators.*;
import testing.generation.*;
import testing.generation.conversion.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Comparator<MarkedValue<Integer>> markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());
		
		Generator<MarkedValue<Integer>> generator = new MarkingGenerator<Integer>(new ShuffledIntegerArrayGenerator());

		LinkedListGenerator<MarkedValue<Integer>> llGenerator = new LinkedListGenerator<>(generator);

		PivotRnd pivot = new PivotRnd();
		AbstractSwappingSortingAlgorithm<MarkedValue<Integer>> algorithm = new QuickSort<MarkedValue<Integer>>(markedComparator, pivot);
		
		//AbstractSortingAlgorithm<MarkedValue<Integer>> algorithm = new MergeSort<MarkedValue<Integer>>(markedComparator);
		int[] array = {0,10,20,40,80,100,150,250,500,1000,2000,10000,20000};
		
		for(int i=1;i<array.length;i++){
			Thread.sleep(1);
			System.out.print(array[i] + ";");
			testing.results.swapping.Result result = Tester.runNTimes(algorithm, llGenerator, array[i], 20);
		
			printStatistic(result.averageTimeInMilliseconds(), result.timeStandardDeviation());
			printStatistic(result.averageComparisons(), result.comparisonsStandardDeviation());
			printStatistic(result.averageSwaps(), result.swapsStandardDeviation());

			System.out.println();
		}
		
		/*testing.results.Result result = Tester.runNTimes(algorithm, generator, array[4], 20);
	
		printStatistic(result.averageTimeInMilliseconds(), result.timeStandardDeviation());
		printStatistic(result.averageComparisons(), result.comparisonsStandardDeviation());
		//printStatistic(result.averageSwaps(), result.swapsStandardDeviation());
		System.out.println("always sorted: " + result.sorted());
		System.out.println("always stable: " + result.stable());
		*/
	}
	
	private static void printStatistic(double average, double stdDev) {
		System.out.print(double2String(average) + ";" + double2String(stdDev) + ";");
	}
	
	private static String double2String(double value) {
		return String.format("%.12f", value);
	}
}
