import React from 'react';
import { FaGithubAlt, FaEnvelope, FaPhone, FaMapMarker, FaLinkedinIn } from 'react-icons/fa';

import Header from './components/Header';
import Contacts from './components/Contacts';
import Education from './components/Education';
import Skills from './components/Skills';
import './App.css';

const skills = [
  { text: 'Sleeping', level: 'advanced' },
  { text: 'Running', level: 'beginner' },
  { text: 'Coding', level: 'intermediate' },
  { text: 'Speaking', level: 'intermediate' },
  { text: 'Listening', level: 'beginner' },
  { text: 'Driving', level: 'beginner' },
  { text: 'Eating', level: 'advanced' },
  { text: 'MS Word', level: 'beginner' },
];
const education = [
  {
    degree: 'PHD',
    university: 'Hogwartz',
    year: '2020 - present',
  },
];
const contacts = [
  {
    icon: FaMapMarker,
    text: 'Vilnius, Lithuania',
    link: 'https://www.google.com/maps/place/Vilnius/@54.6998479,24.9727564,10z/',
  },
  {
    icon: FaGithubAlt,
    text: '@Mindaugas-Jacionis',
    link: 'https://github.com/mindaugas-jacionis/',
  },
  {
    icon: FaEnvelope,
    text: 'test@dummy.test',
    link: 'mailto:test@dummy.test?subject=Email from CV',
  },
  {
    icon: FaPhone,
    text: '+4412345678909',
    link: 'tel:+4412345678909',
  },
  {
    icon: FaLinkedinIn,
    text: 'Linkedin.com/Mindaugas-Jacionis',
    link: 'https://linkedin.com/mindaugas-jacionis',
  },
];

function App() {
  return (
    <div className="App">
      <Header />
      <main className="App--content">
        <div className="App--content-left">
          <Contacts items={contacts} />
          <Education items={education} />
          <Skills items={skills} />
        </div>
        <div className="App--content-right">Main content</div>
      </main>
    </div>
  );
}

export default App;
