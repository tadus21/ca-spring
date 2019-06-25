import React from 'react';
import './index.css';

function Link(props) {
  return (
    <a className="Link" target={props.target || '_blank'} href={props.href}>
      {props.children}
    </a>
  );
}

export default Link;
