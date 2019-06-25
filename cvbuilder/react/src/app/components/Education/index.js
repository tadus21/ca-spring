import React from 'react';
import './index.css';

function Item(data) {
  return (
    <div className="Education--item">
      <h5 className="Education--item-degree">{`Degree: ${data.degree}`}</h5>
      <p className="Education--item-university">{data.university}</p>
      <p className="Education--item-year">{data.year}</p>
    </div>
  );
}

function Education(props) {
  return (
    <section className="Education">
      <h3>Education</h3>
      {props.items.map(Item)}
    </section>
  );
}

export default Education;
