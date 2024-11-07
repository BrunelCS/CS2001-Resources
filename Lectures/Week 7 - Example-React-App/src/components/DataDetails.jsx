import { useOutletContext } from "react-router-dom"

export default function DataDetails(){
    const context = useOutletContext();
    
    if(!context || context.user==undefined){
        return(<p>No further details</p>)
    }else{
        return(
        <p>Here are more details for {context.user}</p>
        )
    }
}
