import axios from "axios"
import { useHistory } from "react-router"

const FeedbackRow = ({f}) =>{
    const url = "http://localhost:8080"
    const history = useHistory()
    
    const deleteFeedback = () =>{
        const body ={
            "feedbackId":f.feedbackId
        }
        axios.post(url+"/feedback/delete",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert("Feedback deleted successfully")
                history.push("/TeacherHome")
            }
        })
    }
    return (
        <tr>
            <td>{f.studentName}</td>
            <td>{f.std}</td>
            <td>{f.subjectName}</td>
            <td>{f.feedbackRatings}/5</td>
            <td>{f.feedbackRemarks}</td>
            <td>
                <button className="button-delete" onClick={deleteFeedback}>DELETE</button>
            </td>
        </tr>
    )
}
export default FeedbackRow