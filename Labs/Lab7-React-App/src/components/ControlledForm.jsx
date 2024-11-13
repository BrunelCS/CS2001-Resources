import { useState } from "react";

function ControlledForm(){

    const [formData, setformData] = useState({
        name: '',
        email:'',
        password:'',
        repPass:'',
        buyer:false,
        seller:false,
        tos:false
    });

    const handleChange = (event) => {

        const {name, value, type, checked} = event.target;
        setformData((prevData) => ({
            ...prevData,
            [name]: type === "checkbox"? checked : value, // Updates only the field that changed and checks for checkbox inputs
        }))

    }

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log('Form Data:', formData);
    }

    return(
        <form className="registration">
            <label className="labelText">Name:
                <input type="text" className="inputText" name="name" value={formData.name} onChange={handleChange}/>
            </label><br/><br/>

            <label className="labelText">Email:
                <input type="text" className="inputText" name="email" value={formData.email} onChange={handleChange}/>
            </label><br/><br/>

            <label className="labelText">Password:
                <input type="text" className="inputText" name="password" value={formData.password} onChange={handleChange}/>
            </label><br/><br/>

            <label className="labelText">Re-type password:
                <input type="text" className="inputText" name="repPass" value={formData.repPass} onChange={handleChange}/>
            </label><br/><br/>

            <input type="checkbox" name="buyer" value={formData.buyer} onClick={handleChange}/>
            <label>I want to buy produce directly from allotment owners.</label><br/>

            <input type="checkbox" name="seller" value={formData.seller} onClick={handleChange}/>
            <label>I want to sell produce from my allotment.</label><br/><br/>

            <input type="checkbox" name="tos" value={formData.tos} onClick={handleChange}/>
            <label>I agree to the Terms of Use and Privacy Policy.</label><br/><br/>


            <button type="submit" onClick={handleSubmit}>Submit</button>
        </form>
    )
}

export default ControlledForm;