import React from 'react'
import './style.css'
const Login = () => {
  return (
    <div className='d-flex justify-content-center align-items-center vh-100 loginPage'>
      <div className='p-3 rounded w-25 border loginForm '>
        <h2>Login page</h2>
        <form action="" >
            <div>
                <label htmlFor="email"><strong>Email</strong></label>
                <input type="email" name='email' autoCapitalize='off' placeholder='Ton email' className='form-control rounded-0' />
            </div>
            <div>
                <label htmlFor="password"><strong>Mot de passe</strong></label>
                <input type="password" name='password' autoCapitalize='off' placeholder='Ton mot de passe' className='form-control rounded-0' />
            </div>
            <button className="btn btn-success w-100 rounded-0"> Entrer</button>
        </form>
      </div>
    </div>
  )
}

export default Login
