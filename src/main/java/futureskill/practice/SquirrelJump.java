package futureskill.practice;

import java.util.*;

public class SquirrelJump {
	static HashMap<Integer, Integer> positionStepsMap = new HashMap<>();
	static Map<String,List<Integer>> stepsMap = new HashMap<>();
	static int maxJumpStep = 0;
	public static void main(String[] args) {
	    int[] bars = null;
	    
		bars = new int[]{5,4,6,11,7,10,8,9,9,10,5,4,5};
		SquirrelJump.jump(bars);
		bars = new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
		SquirrelJump.jump(bars);
		bars = new int[]{12,10,8, 6, 4, 2};
		SquirrelJump.jump(bars);
		bars = new int[]{1};
		SquirrelJump.jump(bars);

	}

	private static void jump(int[] bars){
		int maxJumps = 0;
		for (int i = 0; i < bars.length; i++) {
			maxJumps = Math.max(jump(bars, i, positionStepsMap), maxJumps);
		}
		maxJumpStep = maxJumps;
		int position = findMaxJumpPosition();
		positionForStep(bars,position);
		positionStepsMap.clear();
		stepsMap.clear();
		System.out.println("Max number of jumps: " + maxJumps);
	}

	private static int jump(int[] bars, int position, Map<Integer, Integer> positionStepsMap) {
	    int numOfSteps = 0;
	    if (positionStepsMap.containsKey(position)) return positionStepsMap.get(position);
	    for (int i = position - 2; i <= position + 2; i++) {
	        if (i < 0 || i == position || i >= bars.length) continue;
	        if (bars[i] < bars[position]) {
	            numOfSteps = Math.max(jump(bars, i, positionStepsMap) + 1, numOfSteps);
	        }
	    }
	    positionStepsMap.put(position, numOfSteps);
	    return numOfSteps;
	}
	public int positionAtStep(int step) {
		// Write your code here
		int position = 0;
		System.out.println(positionStepsMap);
		for(Map.Entry<Integer,Integer> entries : positionStepsMap.entrySet()){
			if(entries.getValue() == step){
				position = entries.getKey();
				break;
			}
		}


		return position;
	}

	public static int findMaxJumpPosition(){
		int position = 0;
		for(Map.Entry<Integer,Integer> entries : positionStepsMap.entrySet()){
			if(entries.getValue() == maxJumpStep){
				position = entries.getKey();
				break;
			}
		}
		return position;
	}

	public static int positionForStep(int[] bars, int position) {
		stepsMap.putIfAbsent("LEFT",new ArrayList<>());
		int resultPos = 0;
		int i = 0;
		for(i = position ; i > 0;i = resultPos ) {
			int max = 0;

			if (i - 2 >= 0 ) {
				if (bars[i] > bars[i - 2] && bars[i] > bars[i - 1]) {
					if (bars[i - 2] > bars[i - 1]) {
						resultPos = i - 2;
					} else {
						resultPos = i - 1;
					}
				}else if (bars[i] > bars[i - 2]) {
					resultPos = i - 2;
				} else if (bars[i] > bars[i - 1]) {
					resultPos = i - 1;
				}

			} else if(i-1 >=0){
				if (bars[i] > bars[i-1]) {
					resultPos = i-1;
				}
			}else {
				
				break;
			}
			if(!(resultPos == i))
			stepsMap.get("LEFT").add(resultPos);
			if(resultPos == i || i <=0)
				break;
		}
		stepsMap.putIfAbsent("RIGHT",new ArrayList<>());
		resultPos = 0;
		for(i = position ; i <= bars.length-1;i = resultPos ){
			int max = 0;

			if(i+2 <=bars.length-1) {
				if(bars[i] > bars[i+2] && bars[i] > bars[i+1]) {
					if (bars[i + 2] > bars[i + 1]) {
						resultPos = i + 2;
					} else {
						resultPos = i + 1;
					}
				} else if (bars[i] > bars[i+2]) {
					resultPos = i + 2;
				} else if (bars[i] > bars[i+1]) {
					resultPos = i + 1;
				}else if(bars[i] > bars[i-1]) {
					resultPos = i -1;
				}else if(bars[i] > bars[i-2]) {
					resultPos = i -2;
				}
			} else if(i+1 <=bars.length-1){
				if (bars[i] > bars[i+1]) {
					resultPos = i + 1;
				}
			}
			
				else {
				
				break;
			}

			if(!(resultPos == i))
			stepsMap.get("RIGHT").add(resultPos);
			if(resultPos == i|| i >= bars.length-1)
				break;
		}
		System.out.println(stepsMap);
		return 0;
	}
}
