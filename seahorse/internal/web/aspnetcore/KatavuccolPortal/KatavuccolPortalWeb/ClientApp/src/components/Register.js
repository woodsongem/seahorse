
import React, { Component } from 'react';

export class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isValidated:false,
            firstname: '',
            lastname: '',
            password: '',
            confirmpassword: '',
            username: '',
            phonenumber: '',
            emailaddress: '',
            errorsflag: {
                firstname:false,
                lastname:false,
                password:false,
                confirmpassword:false,
                username:false,
                emailaddress:false

            },
            errorsmsg: {
                firstname:'Required field',
                lastname:'Required field',
                password:'Required field',
                confirmpassword:'Required field',
                username:'Required field',
                emailaddress:'Required field'

            }
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.registerSubmit = this.registerSubmit.bind(this);
    }

    validateRegField(){
        let errordetail=this.state.errorsmsg;
        let errorflag=this.state.errorsflag;

        let errorFlag=true;
        if(this.state.firstname === null || this.state.firstname === undefined
        || this.state.firstname.trim() === "" || this.state.firstname.length >= 50)
        {
            errordetail.firstname="first name should be less than 50 characters and greater than 1";
            errorflag.firstname=true;
            errorFlag=false;
           
        }

        if(this.state.lastname === null || this.state.lastname === undefined || this.state.lastname.trim() === ""
        || this.state.lastname.length >=50)
        {
            errordetail.lastname="last name should be less than 50 characters and greater than 1";
            errorflag.lastname=true;
            errorFlag=false;
        }

        if(this.state.password === null || this.state.password === undefined || this.state.password.trim() === ""
        || this.state.password.length > 15 || this.state.password.length < 8)
        {
            errordetail.password="Password should be less than 15 characters and greater than 8";
            errorflag.password=true;
            errorFlag=false;
        }

        if(this.state.emailaddress === null || this.state.emailaddress === undefined || this.state.emailaddress.trim() === "")
        {
            //errordetail.emailaddress="Password should be less than 15 characters and greater than 8";
            errorflag.emailaddress=true;
            errorFlag=false;
        }

         if(this.state.username === null || this.state.username === undefined || this.state.username.trim() === "")
        {
            //errordetail.username="Password should be less than 15 characters and greater than 8";
            errorflag.username=true;
            errorFlag=false;
        }

        if(this.state.confirmpassword === null || this.state.confirmpassword.trim() === "")
        {
            errordetail.confirmpassword="Confirm password should not be null";
            errorflag.confirmpassword=true;
            errorFlag=false;
        }

        if(this.state.confirmpassword !== this.state.password)
        {
            errordetail.confirmpassword="Password and Confirm password not same";
            errordetail.password="Password and Confirm password not same";
            errorflag.confirmpassword=true;
            errorflag.password=true;
            errorFlag=false;
        }
        this.setState({errorsmsg:errordetail});
        this.setState({errorflag:errorflag});
        this.setState({isValidated:errorFlag});

        return errorFlag;
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
                        <form onSubmit={this.registerSubmit} >
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contacts</i>
                                    <input id="txt_firstname" name="firstname" type="text" aria-required="true" className={this.state.errorsflag["firstname"] ? "validate invalid" : "validate"} value={this.state.firstname} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_firstname" >First Name</label>
                                    <span className="helper-text" data-error={this.state.errorsmsg["firstname"]}></span>
                                </div>
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contacts</i>
                                    <input id="txt_lastname" name="lastname" type="text" aria-required="true" className={this.state.errorsflag["lastname"] ? "validate invalid" : "validate"} value={this.state.lastname} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_lastname">Last Name</label>
                                    <span className="helper-text" data-error={this.state.errorsmsg["lastname"]}></span>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">vpn_key</i>
                                    <input id="txt_password" name="password" type="password" aria-required="true" className={this.state.errorsflag["password"] ? "validate invalid" : "validate"} value={this.state.password} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_password">Password</label>
                                    <span className="helper-text" data-error={this.state.errorsmsg["password"]}></span>
                                </div>
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">replay</i>
                                    <input id="txt_confirmpassword" name="confirmpassword" type="password" aria-required="true" className={this.state.errorsflag["confirmpassword"] ? "validate invalid" : "validate"} value={this.state.confirmpassword} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_confirmpassword">Retype Password</label>
                                    <span className="helper-text" data-error={this.state.errorsmsg["confirmpassword"]}></span>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">account_circle</i>
                                    <input id="txt_username" name="username" type="text" className={this.state.errorsflag["username"] ? "validate invalid" : "validate"} aria-required="true" value={this.state.username} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_username">Username</label>
                                    <span className="helper-text" data-error={this.state.errorsmsg["username"]}></span>
                                </div>
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">email</i>
                                    <input id="txt_emailaddress" name="emailaddress" type="email" aria-required="true" className={this.state.errorsflag["emailaddress"] ? "validate invalid" : "validate"} value={this.state.emailaddress} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_emailaddress">Email</label>
                                    <span className="helper-text" data-error={this.state.errorsmsg["emailaddress"]}></span>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-field hoverable col s6">
                                    <i className="material-icons prefix">contact_phone</i>
                                    <input id="txt_phonenumber" name="phonenumber" type="text" aria-required="true" className={this.state.errorsflag["phonenumber"] ? "validate invalid" : "validate"} value={this.state.phonenumber} onChange={this.handleInputChange} required></input>
                                    <label htmlFor="txt_phonenumber" data-error={this.state.errorsmsg["phonenumber"]}>Phone Number</label>
                                    <span className="helper-text" data-error={this.state.errorsmsg["phonenumber"]}></span>
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