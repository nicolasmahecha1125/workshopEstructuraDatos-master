import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> stack = new Stack<>();

		while (!tags.isEmpty()) {
			HtmlTag tag = tags.poll();

			if (tag.isOpenTag()) {
				stack.push(tag);
			} else if (tag.isSelfClosing()) {
			} else {
				if (stack.isEmpty()) {
					return null;
				} else if (!tag.matches(stack.peek())) {

					return stack;
				}
				stack.pop();
			}
		}
		return stack;
	}

}