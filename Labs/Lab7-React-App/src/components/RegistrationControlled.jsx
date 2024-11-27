import { useState } from "react"
import axios from "axios"

export default function RegistrationControlled(){

    const [formData, setFormData] = useState({
        name:'',
        email:'',
        password:'',
        repPassword:'',
        buyer: false,
        seller: false,
        tos: false
    })

    const handleChangeText = (event) => {
        const {name, value} = event.target

        setFormData((prevData)=>({
            ...prevData,
            [name]:value
        }))
    }

    const handleChangeCheckbox = (event) => {
        const name = event.target.name

        setFormData((prevData)=>({
            ...prevData,
            [name]:event.target.checked
        }))
    }

    const validateForm = () => {
        let formValid = false;
        console.log(formData)

        var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
   
        if ((formData.name.length==0) || 
               (formData.email.length==0)  ||
               (formData.password.length==0) ||
               (formData.repPassword.length == 0)){
                alert("Please fill in all text fields.");
        } else if (!formData.email.match(mailformat)){
            alert("Invalid e-mail address. Please enter your e-mail again.");
        } else if (formData.password.length < 8){
            alert("Password is too short. Please select another password");
        } else if(formData.password !== formData.repPassword) {
            alert("Passwords do not match. Please retry");
        } else if(!formData.buyer && !formData.seller){
            alert("Please check at least one checkbox to be a seller or a buyer.")
        } else if (!formData.tos){ 
            alert("Please agree to the Terms and Conditions, and Privacy Policy.")
        }else {
            formValid = true;
        }
   
        return formValid;
    }
    
    const handleSubmit = async (event) => {
        event.preventDefault()

        const dataToSend = (({ name, email, password, buyer, seller }) => ({name, email, password, buyer, seller}))(formData);

        if(validateForm()){
            try{
                const response = await axios.post('https://reqres.in/api/users', dataToSend);

                console.log(response);
                if (response.status === 201) {
                    alert("Registered successfully.");
                }

                // Clear input fields after successful registration
                setFormData(() =>({
                name :'',
                email:'',
                password:'',
                repPassword:'',
                buyer:false,
                seller:false,
                tos:false
            }))
            } catch (error) {
                console.log(error);
            }
           
        }
    }
    
    return(
        <form className="registration" noValidate>
        <label className="labelText">Name: </label>
        <input type="text" className="inputText" name="name" value={formData.name} onChange={handleChangeText} required autoComplete="off"/><br/><br/>

        <label className="labelText">Email:</label>
        <input type="email" className="inputText" name="email" value={formData.email} onChange={handleChangeText} required autoComplete="off"/><br/><br/>

        <label className="labelText">Password:</label>
        <input type="password" className="inputText" name="password" value={formData.password} onChange={handleChangeText} required minLength="8"/><br/><br/>

        <label className="labelText">Re-type password:</label>
        <input type="password" className="inputText" name="repPassword" value={formData.repPassword} onChange={handleChangeText} required/><br/><br/>
     
        <input type="checkbox" name="buyer"  checked={formData.buyer} onChange={handleChangeCheckbox} />
        <label>I want to buy produce directly from allotment owners.</label><br/>

        <input type="checkbox" name="seller" checked={formData.seller} onChange={handleChangeCheckbox}/>
        <label>I want to sell produce from my allotment.</label><br/><br/>

        <input type="checkbox" name="tos" checked={formData.tos} onChange={handleChangeCheckbox} required/>
        <label>I agree to the Terms of Use and Privacy Policy.</label>
        <br/><br/>

        <button onClick={handleSubmit}>Submit</button>
    </form>
    )
}