defmodule ColdfishportalWeb.ContactusController do
	use ColdfishportalWeb, :controller

	def index(conn, _params) do
		render conn,"contactus.html"
	end
end
