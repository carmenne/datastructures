import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

  /**
   * @param tags, queue will all the tags encountered in the file
   * @return empty Stack means that the html is valid
   */
  public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

    if (tags == null || tags.isEmpty()) {
      return null;
    }

    Stack<HtmlTag> stackedTags = new Stack<HtmlTag>();
    
    // Put the first element into the stack to make sure the stack is not empty

    while (stackedTags.isEmpty()) {
      HtmlTag tag = tags.poll();
      if (tag.isOpenTag()) {
        stackedTags.push(tag);
      } else if (!tag.isSelfClosing()) {
        // I must have encountered a closing tag without an opening one
        return null;
      }
    }

    while (null != tags.peek() && !stackedTags.isEmpty() ) {
      HtmlTag tag = tags.poll();
      // if it is self enclosing tag, ignore it
      if (!tag.isSelfClosing()) {

        if (tag.isOpenTag()) {
          stackedTags.push(tag);
        } else {
          if (stackedTags.peek().matches(tag)) {
            stackedTags.pop();
          } else {
            // Encountered a non matching tag
            return stackedTags;
          }
        }
      }

    }
    
    
    if (null != tags.peek()) {
      return null;
    }

    return stackedTags; // this line is here only so this code will compile if you don't modify it
  }


}

