import java.util.Stack;

/**
 * 테스트 코드를 보고, 아래 두 method 를 작성해주세요.
 */
class Questing {
	static int quest1(double d) {
		// FIXME
		try {
			// int 형으로 강제 변환한 데이터를 2로 나누어 몫을 반환한다.
			final int result = ((int) d) / 2;
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

	static boolean quest2(String s) {
		// FIXME
		try {
			// final char[] results = s.toCharArray();
			// final char[] opens = { '{', '}', '[',']' };
			final Stack stack = new Stack<>();

			final int startIdx = s.indexOf('(');
			final int lastIdx = s.indexOf(')');

			final char[] datas = (s.substring(startIdx+1, lastIdx)).toCharArray();

			int result = -1;
			for (int i = 0; i < datas.length; i++) {
				if ((datas[i] == '{') || (datas[i] == '[')) {
					if (!stack.isEmpty()) { // 이미 괄호가 추가되어 있다면 false
						return false;
					} else {
						stack.push(datas[i]);
					}
				}

				else if ((datas[i] == '}') || (datas[i] == ']')) {
					final char lastData = (char) stack.peek();

					if (stack.isEmpty()) { // 아무것도 없다면
						return false;
					} else if ((datas[i] == '}') && (lastData == '{')) {
						stack.pop();
					} else if ((datas[i] == ']') && (lastData == '[')) {
						stack.pop();
					}
					
					else{
						return false;
					}
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
