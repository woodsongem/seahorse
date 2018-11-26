
import React, { Component } from 'react';
const $ = window.$;

export class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstname: '',
            lastname: '',
            password: '',
            confirmpassword: '',
            username: '',
            phonenumber: '',
            emailaddress: ''
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.registerSubmit = this.registerSubmit.bind(this);
    }

    validateRegField(){

        if(this.state.firstname === null || this.state.firstname === undefined
        || this.state.firstname.trim() === "" || this.state.firstname.length >= 50)
        {
            $("#txt_firstname").addClass("invalid");
        }

        if(this.state.lastname === null || this.state.lastname === undefined
        || this.state.lastname.length >=50)
        {
            
        }



        if(this.state.password === null || this.state.password === undefined
        || this.state.password.length > 15 || this.state.password.length < 8)
        {
            
        }

        if(this.state.confirmpassword === null)
        {
            
        }

        if(this.state.confirmpassword !== this.state.password)
        {
            
        }
        return true;
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    registerSubmit(event) {
        event.preventDefault();
        if(!this.validateRegField())
            return false;
        const data = {
            firstname: this.state.firstname,
            lastname: this.state.lastname,
            password: this.state.password,
            confirmpassword: this.state.confirmpassword,
            username: this.state.username,
            phonenumber: this.state.phonenumber,
            emailaddress: this.state.emailaddress
        };
        fetch('/api/profile', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(data => {
                this.setState({ forecasts: data, loading: false });
            });
    }

    render() {
        return (
            <div className="container z-depth-4">
                <div className="section card">
                    <div className="row">
                        <nav className="blue">
                            <div className="nav-wrapper">
                                <div className="col s8"  >
                                    <h3 className="brand-logo col s8 txtcolor">Please Register</h3>
                                </div>
                            </div>
                        </nav>
                    </div>
                    <div className="row">
                        <form >
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contacts</i>
                                    <input id="txt_firstname" name="firstname" type="text" className="validate" value={this.state.firstname} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_firstname" >First Name</label>
                                    <span className="helper-text" data-error="Required field"></span>
                                </div>
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contacts</i>
                                    <input id="txt_lastname" name="lastname" type="text" className="validate" value={this.state.lastname} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_lastname">Last Name</label>
                                    <span className="helper-text" data-error="Required field"></span>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">vpn_key</i>
                                    <input id="txt_password" name="password" type="password" className="validate" value={this.state.password} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_password">Password</label>
                                    <span className="helper-text" data-error="Required field"></span>
                                </div>
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">replay</i>
                                    <input id="txt_confirmpassword" name="confirmpassword" type="password" className="validate" value={this.state.confirmpassword} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_confirmpassword">Retype Password</label>
                                    <span className="helper-text" data-error="Required field"></span>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">account_circle</i>
                                    <input id="txt_username" name="username" type="text" className="validate" value={this.state.username} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_username">Username</label>
                                    <span className="helper-text" data-error="Required field"></span>
                                </div>
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">email</i>
                                    <input id="txt_emailaddress" name="emailaddress" type="email" className="validate" value={this.state.emailaddress} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_emailaddress">Email</label>
                                    <span className="helper-text" data-error="Required field"></span>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contact_phone</i>
                                    <input id="txt_phonenumber" name="phonenumber" type="text" className="validate" value={this.state.phonenumber} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_phonenumber">Phone Number</label>
                                </div>
                            </div>
                            <div className="row">
                                <div className="center-align">
                                    <a className="waves-effect waves-light hoverable blue btn-large" onClick={this.registerSubmit}>register</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}