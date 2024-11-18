import {useParams} from 'react-router-dom'

export default function ProductDetail(){

    const {productId}=useParams()
    
    return(
        <div>
            This is product detail for {productId}. 
        </div>
    )
}


