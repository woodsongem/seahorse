defmodule ColdfishportalWeb.ForgotCredentialController do
	use ColdfishportalWeb, :controller

	def index(conn, _params) do
		render conn,"forgotcredential.html"
	end
end