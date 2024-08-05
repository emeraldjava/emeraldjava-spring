import html from './utils_html.js';

export default {
    name: `BaseButton`,
    render() {
        return html`
      <button>
        ${this.$slots.default()}
      </button>
    `;
    },
};