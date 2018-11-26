

import 'materialize-css/dist/css/materialize.css';
import 'material-icons/iconfont/material-icons.css';
import 'materialize-stepper/dist/css/mstepper.css';
import './index.css';
import './css/katavuccolportalweb.css';
import 'prismjs/themes/prism.css';
import 'jquery/dist/jquery.js';
import 'materialize-css/dist/js/materialize.js';
import 'jquery-validation/dist/jquery.validate.js';
import 'materialize-stepper/dist/js/mstepper.js';
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
