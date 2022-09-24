import axios from "axios"
import { useEffect, useState } from "react"
import ViewMarksRow from "./SubComponents/ViewMarksRow";

const ViewMarksOfStudents = (props) =>{
    const userId = props.location.aboutProps.id.user


    const [markList,setMarkList] = useState([])

    const url = "http://localhost:8080"
     useEffect(() =>{
        showResult()
     },[])

    const showResult = () =>{
        const body ={
            "studentId":userId
        }
        axios.post(url+"/marks/getResult",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                console.log(result.data)
                setMarkList(result.data)
            }
        })
    }
    return (
        <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <th>Subject Code</th>
                        <th>Subject Name</th>
                        <th>Marks</th>
                        <th>Assignment Marks</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        markList.map((mark) =>{
                            return <ViewMarksRow m={mark} />
                        })
                    }  
                </tbody>
            </table>
            <br/><br/>
            <br/><br/>
            <br/><br/>
            <br/>
            <br/>
            <br/>
            <br/><br/>
        </div>
    )
}
export default ViewMarksOfStudents