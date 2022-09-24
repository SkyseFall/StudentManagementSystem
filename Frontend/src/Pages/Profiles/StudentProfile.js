import axios from "axios";
import { useEffect, useState } from "react";
import { useHistory, useLocation } from "react-router"

const StudentProfile = () => {

    const location = useLocation()
    const data = location.state
    const history = useHistory();
    useEffect(() => {
        Defaults()
    }, [])

    const [userId, setUserId] = useState(data.userId);
    const [firstName, setFirstName] = useState(data.firstName);
    const [lastName, setLastName] = useState(data.lastName)
    const [dob, setDob] = useState(data.dob)
    const [gender, setGender] = useState(data.gender)
    const [locality, setLocality] = useState(data.locality)
    const [mobile, setMobile] = useState(data.mobile)
    const [pincode, setPincode] = useState(data.pincode)
    const [section, setSection] = useState(data.section)
    const [std, setStd] = useState(data.std)
    const [username, setUsername] = useState(data.username)

    function Defaults() {
        //console.log(data.firstName)
        document.getElementById("firstName").defaultValue = data.firstName
        document.getElementById("lastName").defaultValue = data.lastName
        document.getElementById("gender").defaultValue = data.gender
        document.getElementById("dob").defaultValue = data.dob
        document.getElementById("locality").defaultValue = data.locality
        document.getElementById("mobile").defaultValue = data.mobile
        document.getElementById("pincode").defaultValue = data.pincode
        document.getElementById("section").defaultValue = data.section
        document.getElementById("className").defaultValue = data.std
        document.getElementById("username").defaultValue = data.username
    }

    const UpdateProfile = () => {
        //console.log(data)
        const body = {
            "userId": userId,
            "firstName": firstName,
            "lastName": lastName,
            "dob": dob,
            "gender": gender,
            "locality": locality,
            "mobile": mobile,
            "pincode": pincode,
            "section": section,
            "std": std,
            "username": username
        }
        const url = "http://localhost:8080"
        axios.post(url + "/student/updateProfile", body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                window.alert("User Updated successfully")
                history.push('/AdminHome')
            } else {
                window.alert(result.error)
            }
        })
    }

    return (
        <div className="container">
            <div className="adminProfile"><h4 asign="center"> Student Profile</h4>
                <table>
                    <tbody>
                        <tr>
                            <td>Registration Id : </td>
                            <td>
                                <input type="number" disabled value={data.userId} onChange={e => { setUserId(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>First Name : </td>
                            <td>
                                <input id="firstName" type="text" onChange={e => { setFirstName(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>Last Name : </td>
                            <td>
                                <input id="lastName" type="text" onChange={e => { setLastName(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>Date of Birth : </td>
                            <td>
                                <input id="dob" type="date" onChange={e => { setDob(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>Gender : </td>
                            <td>
                                <div className="input-box">

                                    <select id="gender" name="gender" onChange={e => { setGender(e.target.value) }}>
                                        <option value={gender}>{gender}</option>
                                        <option value="male">Male</option>
                                        <option value="female">Female</option>
                                        <option value="other">Other</option>
                                    </select>
                                </div>

                            </td>
                        </tr>
                        <tr>
                            <td>Locality : </td>
                            <td>
                                <input id="locality" type="text" onChange={e => { setLocality(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>Mobile : </td>
                            <td>
                                <input id="mobile" type="number" onChange={e => { setMobile(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>Pincode : </td>
                            <td>
                                <input id="pincode" type="number" onChange={e => { setPincode(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>Section : </td>
                            <td>
                                <input id="section" disabled type="text" onChange={e => { setSection(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>Class : </td>
                            <td>
                                <input id="className" disabled type="text" onChange={e => { setStd(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>Username : </td>
                            <td>
                                <input id="username" type="text" onChange={e => { setUsername(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td colSpan="2">
                                <button className="button-show" onClick={UpdateProfile} >Update</button>
                            </td>

                        </tr>
                    </tbody>
                </table>
            </div></div>
    )
}
export default StudentProfile