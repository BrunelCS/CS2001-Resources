import {useRef} from "react";
import axios from "axios";


export default function Registration(){
    const name=useRef();
    const email=useRef();
    const password=useRef();
    const repPassword=useRef();
    const buyer=useRef();
    const seller=useRef();
    const tos=useRef();

    const validateForm = () => {
        let formValid = false;

        if (name.current.validity.valueMissing 
            || email.current.validity.valueMissing 
            || password.current.validity.valueMissing
            || repPassword.current.validity.valueMissing){
                alert("Please fill in all text fields.");
        }
        else if (email.current.validity.typeMismatch){
            alert("Invalid e-mail address. Please enter your e-mail again.");
        }else if (password.current.validity.tooShort){
            alert("Password is too short. Please select another password");
        } else if(password.value !== repPassword.value) {
            alert("Passwords do not match. Please retry");
        } else if (!buyer.current.checked && !seller.current.checked){
            alert("Please check at least one checkbox to select being a seller or a buyer in the system.")
        } else if (tos.current.validity.valueMissing){
            alert("Please agree to the Terms and Conditions, and Privacy Policy.")
        }else{
            formValid = true;
        }
        return formValid;
    }


    const handleSubmit = async (event) => {
        event.preventDefault();
    
        if (validateForm()) {
            try {
                const response = await axios.post('https://reqres.in/api/users', {
                    name: name.current.value,
                    email: email.current.value,
                    password: password.current.value,
                    buyer: buyer.current.checked,
                    seller: seller.current.checked
                });
    
                console.log(response);
    
                if (response.status === 201) {
                    alert("Registered successfully.");
                }
    
                // Clear input fields after successful registration
                name.current.value = "";
                email.current.value = "";
                password.current.value = "";
                repPassword.current.value = "";
                buyer.current.checked = false;
                seller.current.checked = false;
                tos.current.checked = false;
    
            } catch (error) {
                console.log(error);
            }
        }
    };
    

    return (
        <form className="registration" noValidate>
            <label className="labelText">Name: </label>
            <input type="text" className="inputText" ref={name} name="name" required autoComplete="off"/><br/><br/>

            <label className="labelText">Email:</label>
            <input type="email" className="inputText" ref={email} name="email" required autoComplete="off"/><br/><br/>

            <label className="labelText">Password:</label>
            <input type="password" className="inputText" ref={password} name="password" required minLength="8"/><br/><br/>

            <label className="labelText">Re-type password:</label>
            <input type="password" className="inputText" ref={repPassword} name="repPassword"  required/><br/><br/>
         
            <input type="checkbox" ref={buyer} name="buyer"  value="buyer"/>
            <label>I want to buy produce directly from allotment owners.</label><br/>

            <input type="checkbox" ref={seller} name="seller" value="seller"/>
            <label>I want to sell produce from my allotment.</label><br/><br/>

            <input type="checkbox" ref={tos} name="tos" value="tos" required/>
            <label>I agree to the Terms of Use and Privacy Policy.</label>
            <br/><br/>

            <button onClick={handleSubmit}>Submit</button>
        </form>
    )
}