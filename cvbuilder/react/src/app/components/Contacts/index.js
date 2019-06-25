import React, {useState} from 'react';
import './index.css';
import {useFetch} from "../../utils/fetch-hook";
import {API_ENDPOINTS} from "../../utils/constants";
import {FaEnvelope, FaGithubAlt, FaLinkedinIn, FaMapMarker, FaPhone} from 'react-icons/fa';
import {API_DOMAIN} from "../../utils/constants";

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

  const addContact = contact => {
    setData([...data, contact])
  };

  return (
    <section className="Contacts">
      <h3>Contacts</h3>
      {loading ?
        <div>Loading...</div>
        :
        data.map(Item)
      }
      <AddContactForm addContact={addContact}/>
    </section>
  );
}

function AddContactForm(props) {
  const initialFormState = {value: '', type: 'FaEnvelope', url: ''};
  const [contact, setContact] = useState(initialFormState);

  const handleInputChange = event => {
    const {name, value} = event.target;

    setContact({...contact, [name]: value})
  };

  const {loading, data} = useFetch(API_ENDPOINTS.contactsTypes);

  // const createContact = async event => {
  //   event.preventDefault();
  //   if (!contact.value || !contact.type || !contact.url) return;
  //
  //   const response = await fetch(`${API_DOMAIN}${API_ENDPOINTS.addContact}`,
  //     {
  //       body: JSON.stringify(contact), method: 'POST', headers: {
  //         'Accept': 'application/json',
  //         'Content-Type': 'application/json'
  //       }
  //     }).then(resp => resp.json());
  //
  //   props.addContact(response);
  //   setContact(initialFormState)
  // };

  return (
    <form
      onSubmit={event => {
        event.preventDefault();
        if (!contact.value || !contact.type || !contact.url) return;

        props.addContact(contact);
        setContact(initialFormState)
      }}
    >
      <label>Value</label>
      <input type="text" name="value" value={contact.value} onChange={handleInputChange}/>
      <label>Type</label>
      <select value={contact.type} name="type" onChange={handleInputChange}>
        {loading ?
          <div>Loading...</div>
          :
          data.map(type => <option value={type}>{type}</option>)
        }
      </select>
      <label>Url</label>
      <input type="text" name="url" value={contact.url} onChange={handleInputChange}/>
      <button>Add new contact</button>
    </form>
  )
}

export default Contacts;
