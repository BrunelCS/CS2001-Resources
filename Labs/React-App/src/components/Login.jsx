import React, {useRef} from "react";

import { useAuth} from "../customHooks/AuthContext"

import axios from "axios";

export default function Login(){
    const email=useRef();
    const password=useRef();
    const {token, setToken} = useAuth();

    const validateForm = () => {
        let formValid = false;
        if (email.current.validity.valueMissing
            || password.current.validity.valueMissing){
                alert("Please fill in all text fields.");
        }else if (email.current.validity.typeMismatch){
            alert("Invalid e-mail address. Please enter your e-mail again.");
        }else{
            formValid = true;
        }
        return formValid;
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        const dataLogin = {
            username: email.current.value,
            password: password.current.value
        };

        console.log(dataLogin);

        if(validateForm()){
            try{ 
                const response = await axios({
                    method: 'post',
                    url: 'http://localhost:8080/login',
                    data: dataLogin
                })

                console.log(response);
                if (response.status === 200){
                    alert("Logged in successfully.")
                    const jwtToken = response.headers.authorization.split(' ')[1]
                    if (jwtToken !== null) {
                        setToken(jwtToken);
                        console.log(jwtToken);
                    } else{
                        alert("Token failure!");
                        setToken(null);
                    }
                }else{
                    alert("Login error!")
                    setToken(null);
                }

                email.current.value="";
                password.current.value="";
            } catch(error){
                alert("Login error!")
                setToken(null);
                console.log(error);
            }
        }
      }

    return (
        <form className="form" noValidate onSubmit={handleSubmit}>
            <label className="labelText">Email:</label>
            <input type="email" ref={email} name="email" required/><br/><br/>

            <label className="labelText">Password:</label>
            <input type="password" ref={password} name="password" required/><br/><br/>
            <input type="submit" value="Submit"/>
        </form>
    )
}