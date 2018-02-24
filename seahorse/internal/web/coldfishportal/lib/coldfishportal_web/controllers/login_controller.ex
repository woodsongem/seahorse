defmodule ColdfishportalWeb.LoginController do
use ColdfishportalWeb, :controller
	def index(conn, _params) do
		render conn,"login.html" 
	end
end