import React, { useRef } from 'react';

function Registration() {
  // Create refs for each input field
  const firstNameRef = useRef(null);
  const lastNameRef = useRef(null);
  const emailRef = useRef(null);
  const passwordRef = useRef(null);

  // Function to handle form submission
  const handleSubmit = (event) => {
    event.preventDefault();  // Prevent the default form submission behavior

    // Get the current values from the inputs using the refs
    const firstName = firstNameRef.current.value;
    const lastName = lastNameRef.current.value;
    const email = emailRef.current.value;
    const password = passwordRef.current.value;

    // Alert the values to check if they are being read correctly
    alert(`First Name: ${firstName}\nLast Name: ${lastName}\nEmail: ${email}\nPassword: ${password}`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>First Name: </label>
        <input type="text" ref={firstNameRef} placeholder="Enter first name" />
      </div>
      <div>
        <label>Last Name: </label>
        <input type="text" ref={lastNameRef} placeholder="Enter last name" />
      </div>
      <div>
        <label>Email: </label>
        <input type="email" ref={emailRef} placeholder="Enter email" />
      </div>
      <div>
        <label>Password: </label>
        <input type="password" ref={passwordRef} placeholder="Enter password" />
      </div>
      <button type="submit">Register</button>
    </form>
  );
}

export default Registration;
