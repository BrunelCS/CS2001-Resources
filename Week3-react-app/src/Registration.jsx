import React, { useRef } from 'react';
import axios from 'axios';

const Registration = () => {
  const nameRef = useRef(null);
  const emailRef = useRef(null);
  const passwordRef = useRef(null);
  const confirmPasswordRef = useRef(null);

  // Function to handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    const name = nameRef.current.value;
    const email = emailRef.current.value;
    const password = passwordRef.current.value;
    const confirmPassword = confirmPasswordRef.current.value;

    if (password !== confirmPassword) {
      alert('Passwords do not match!');
      return;
    }

    try {
      const response = await axios.post('https://reqres.in/api/users', {
        name,
        email,
        password
      });
      console.log('Response:', response.data);
      alert('Registration successful');
    } catch (error) {
      console.error('There was an error!', error);
    }
  };

  // Function to fetch all registered users
  const fetchAllUsers = async () => {
    try {
      const response = await axios.get('https://reqres.in/api/users?page=1'); // API to fetch users
      console.log('All Registered Users:', response.data.data);  // Log the list of users
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label>
          <input type="text" ref={nameRef} required />
        </div>
        <div>
          <label>Email:</label>
          <input type="email" ref={emailRef} required />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" ref={passwordRef} required />
        </div>
        <div>
          <label>Confirm Password:</label>
          <input type="password" ref={confirmPasswordRef} required />
        </div>
        <button type="submit">Register</button>
      </form>

      {/* Button to fetch and view all users */}
      <button onClick={fetchAllUsers}>View All Registered Users</button>
    </div>
  );
}

export default Registration;