import React, {useState} from 'react';
import './index.css';
import {useFetch} from "../../utils/fetch-hook";
import {API_DOMAIN, API_ENDPOINTS} from "../../utils/constants";
import {FaEnvelope, FaGithubAlt, FaLinkedinIn, FaMapMarker, FaPhone} from 'react-icons/fa';

const icons = {FaEnvelope, FaPhone, FaMapMarker, FaLinkedinIn, FaGithubAlt};

function Item(data) {
  const Icon = icons[data.type];

  return (
    <a className="Contacts--item" href={data.url}>
      <Icon className="Contacts--item-icon"/>
      <span className="Contacts--item-text">{data.value}</span>
    </a>
  );
}

function Contacts(props) {

  const {loading, data, setData} = useFetch(API_ENDPOINTS.contacts);

  return (
    <section className="Contacts">
      <h3>Contacts</h3>
      {loading ?
        <div>Loading...</div>
        :
        data.map(Item)

      }
    </section>
  );
}

export default Contacts;
