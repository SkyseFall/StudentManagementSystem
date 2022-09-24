import axios from "axios"
import { useEffect, useState } from "react"
import { useLocation } from "react-router"

const url = "http://localhost:8080"



const UploadSolution = () =>{

    const location = useLocation()
    const assignmentRow = location.state
    const [marks,setMarks] = useState([])
    const [file,setFile] = useState(undefined)
    const [subDate,setSubDate] = useState("")
    const Show = () =>{
        console.log(assignmentRow)
    }
    useEffect(() =>{
        getMarksDetails()
    },[])
    
    const getMarksDetails = () =>{
            
            const body={
                "studentId":assignmentRow.studentId,
                "sName": assignmentRow.subjectCode
            }
            axios.post(url+"/marks/marksForFileUpload",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    console.log(result.data)
                    setMarks(result.data)
                    setSubDate(result.sDate)
                    console.log(result.sDate)
                    const subDiv = document.getElementById("submission")
                    if(result.data.assignmentSolution == ""){
                        subDiv.innerHTML = "Nothing Uploaded Yet"
                    }
                }
            })

            
        
    }

    const UploadAssignmentSolution = () =>{
        if(file != null) {
            const data = new FormData()
            data.append('studentId',assignmentRow.studentId)
            data.append('subjectCode',assignmentRow.subjectCode)
            data.append('marks',marks.marks)
            data.append('assignmentMarks',marks.assignmentMarks)
            data.append('marks',marks.assignmentMarks)
            data.append('assignmentSolution',file)
            data.append('marksheetId',marks.marksheetId)

            axios.post(url+"/studentAssignment/submitAssignment",data).then(Response =>{
                const result = Response.data
                if (result.status === 'success') {
                    alert("File uploaded successfully")
                }else{
                    alert("something went wrong while uploading a file")
                }
            })
        }else{
           
            window.alert("Please Choose a file")
            
        }
        
    }

    return(
        <div className="container">
           
           
            <br></br>
            
            <table class="table table-responsive">
                <tbody>
                    <tr>
                        <td>Subject</td>
                        <td>{assignmentRow.subjectName}</td>
                    </tr>
                    <tr>
                        <td>Subject Code</td>
                        <td>{assignmentRow.subjectCode}</td>
                    </tr>
                    <tr>
                        <td>Assignment</td>
                        <td>
                            <a href={url+"/teacherAssignment/"+assignmentRow.addedAssignment} target="_blank">Download</a>
                        </td>
                    </tr>
                    <tr>
                        <td>Given at</td>
                        <td>{assignmentRow.submissionTime}</td>
                    </tr>
                    <tr>
                        <td>Assignment Due</td>
                        <td>{assignmentRow.assignmentDue}</td>
                    </tr>
                    <tr>
                        <td>Solution Uploaded</td>
                        <td id="submission">
                        <a href={url+'/teacherAssignment/'+marks.assignmentSolution} target='_blank'>Download</a>
                            </td>
                    </tr>
                    <tr>
                        <td>Submission Time</td>
                        <td>{subDate}</td>
                    </tr>
                    <tr>
                        <td>Add Solution</td>
                        <td><input type="file" onChange={e=>{setFile(e.target.files[0])}} accept="application/pdf" /></td>
                    </tr>
                </tbody>
            </table>
            <button className="button-small" onClick={UploadAssignmentSolution}>Upload</button>
        </div>
    )
}
export default UploadSolution