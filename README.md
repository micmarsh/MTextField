Welcome to MTextField! I'll write proper javadocs at some point, but really all you really need to know is that this is inherited from http://docs.oracle.com/javase/6/docs/api/javax/swing/JPasswordField.html and implements two new functions:

	*setHidden(boolean hidden) Controls whether or not the text is obscured by dots (false by default)

	*setPrompt(String prompt) Sets a gray text prompt in the text box, which will override the above mentioned dots while visible (nothing by default)

	*disablePrompt() Undoes everything mentioned directly above

See this in action in the desktop widget over at http://www.fetchnotes.com
