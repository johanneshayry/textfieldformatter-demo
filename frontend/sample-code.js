import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import Prism from 'prism-es6';
import '@polymer/prism-element/prism-theme-default.js';
import 'prism-es6/components/prism-java';

class SampleCode extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles prism-theme-default">
                :host {
                    display: block;
                }
            </style>
            <pre>
              <code id="content">
              </code>
            </pre>
`;
    }

    static get is() {
        return 'sample-code';
    }

    static get properties() {
      return {
        detail: {
          type: Object,
          observer: '_detailChanged'
        }
      };
    }

    connectedCallback() {
      super.connectedCallback();
    }

    disconnectedCallback() {
      super.disconnectedCallback();
    }

    _detailChanged(newDetail, oldDetail) {
      if (!newDetail) {
        return;
      }
      // const ev = new CustomEvent('syntax-highlight', { detail: {
      //   code: newDetail.code,
      //   lang: newDetail.lang
      // }});
      // this.dispatchEvent(ev);
      this.$.content.innerHTML = Prism.highlight(newDetail.code, Prism.languages.java, 'java');
    }
}

customElements.define(SampleCode.is, SampleCode);
