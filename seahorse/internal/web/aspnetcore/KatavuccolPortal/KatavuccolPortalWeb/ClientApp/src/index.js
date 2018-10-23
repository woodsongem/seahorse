

import 'materialize-css/dist/css/materialize.css';
import 'material-icons/iconfont/material-icons.css';
import './index.css';
import './css/katavuccolportalweb.css';
import 'prismjs/themes/prism.css';
import 'materialize-css/dist/js/materialize.js';
import 'prismjs/prism.js'
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';

const baseUrl = document.getElementsByTagName('base')[0].getAttribute('href');
const rootElement = document.getElementById('root');

ReactDOM.render(
  <BrowserRouter basename={baseUrl}>
    <App />
  </BrowserRouter>,
  rootElement);

registerServiceWorker();
