''

window.org_vaadin_textfieldformatter_demo_CodeHighlightExtension = function() {

    var el = this.getElement(this.getParentId());

    this.onStateChange = function(e) {
    	Prism.highlightElement(el.firstChild);
    };
}
