import React, { useState } from 'react'
import axios from 'axios'
import './style.css'
import { useNavigate } from 'react-router-dom';
const Login = () => {
    const [values, setValues] = useState({
        email : '',
        password : ''
    });
    const [error, setError] = useState(null);
    const navigate = useNavigate();
    axios.defaults.withCredentials = true;
    const handleSubmit =(event) => {
        event.preventDefault();
        axios.post('http://localhost:3000/auth/signin', values)
        .then(result => {
          if(result.data.loginStatus){
            navigate('/dashboard')
          } else {
            setError(result.data.message)
          }
        })
        .catch(err => console.log(err))
    }
  return (
    <div className='d-flex justify-content-center align-items-center vh-100 loginPage'>
      <div className='p-3 rounded w-25 border loginForm '>
        <div className="text-warning">{error && error}</div>
        <h2>Login </h2>
        <form onSubmit={handleSubmit} >
            <div className='mb-3'>
                <label htmlFor="email"><strong>Email</strong></label>
                <input type="email" onChange={(e)=> setValues({...values, email:e.target.value})} name='email' autoCapitalize='off' placeholder='Ton email' className='form-control rounded-0' />
            </div>
            <div className='mb-3'>
                <label htmlFor="password"><strong>Mot de passe</strong></label>
                <input type="password"  onChange={(e)=> setValues({...values, password:e.target.value})} name='password' autoCapitalize='off' placeholder='Ton mot de passe' className='form-control rounded-0' />
            </div>
            <button className="btn btn-success w-100 rounded-0 mb-2"> Entrer</button>
            <div className='mb-1'>
                <input type="checkbox" name='tick' id='tick' className='me-2'  />

                <label htmlFor="tick">Tu es d'accord avec les conditions d'utilisation</label>
            </div>
        </form>
      </div>
    </div>
  )
}

export default Login
