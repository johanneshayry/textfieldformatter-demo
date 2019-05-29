import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './sample-code.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@polymer/iron-icon/iron-icon.js';

class DemoView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                }

            </style>
<vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;">
 <h2>Heading 2</h2>
 <vaadin-text-field id="creditCardField" placeholder="Enter credit card number">
  <iron-icon icon="lumo:search" slot="prefix"></iron-icon>
 </vaadin-text-field>
 <sample-code id="creditCardCode"></sample-code>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'demo-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(DemoView.is, DemoView);
