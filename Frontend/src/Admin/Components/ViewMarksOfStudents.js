import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router";
import ViewMarksRow from "./SubComponents/ViewMarksRow";

const ViewMarksOfStudents = () =>{
    const [classList,setClassList] = useState([])
    const [c,setC] = useState("1");
    const [students,setStudents] = useState([])
    const [studentId,setStudentId] = useState(0)


    const [markList,setMarkList] = useState([])

    
    const history = useHistory()
    const url = "http://localhost:8080"
     useEffect(() =>{
         getClasses()
     },[])

    const getClasses = () =>{
        axios.get(url+"/class/getDistinctClasses").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setClassList(result.data)
            }else if(result.status == "zero"){
                window.alert(result.message)
                history.push('/AdminHome')
            }
        })
            
    }

    const getStudents = () =>{
        const body ={
            "std":c
        }
        axios.post(url+"/users/getStudentsForClass",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                console.log(result.data)
                setStudents(result.data)
            }
        })
    }

    const showResult = () =>{
        if(studentId != 0){
            const body ={
                "studentId":studentId
            }
            axios.post(url+"/marks/getResult",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    console.log(result.data)
                    setMarkList(result.data)
                }
            })
        }else{
            window.alert("Please select the student")
        }
    }
    return (
        <div className="container">

            Select Class : 

            <select onChange={e=>{setC(e.target.value)}}>
            {                    
                classList.map((l) =>{
                return (
                    <option value={l} key={l}>{l}</option>
                    )
                })
            }
            </select>
            <button className="button-assign" onClick={getStudents}>Show Students</button>
            <br/><br/>

            Select Student : 

            <select onChange={e=>{setStudentId(e.target.value)}}>
            <option value={0}>None</option>
            {                    
                students.map((s) =>{
                return (
                    <option value={s.studentId} key={s.studentId}>{s.studentId} : {s.sName}</option>
                    )
                })
            }
            </select>
            <button className="button-assign"  onClick={showResult}>Show Result</button>
            <br/><br/>
            <table className="table">
                <thead className="tableHead">
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