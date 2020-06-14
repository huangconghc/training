import React from 'react';
import ReactDOM from 'react-dom';
import SurfaceDemo from './Surface/Surface'
import './index.css';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(
  <React.StrictMode>
    <SurfaceDemo />
  </React.StrictMode>,
  document.getElementById('root')
);

serviceWorker.unregister();
