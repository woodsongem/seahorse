defmodule KatavuccolWeb.DashboardController do
	use KatavuccolWeb, :controller

	def index(conn, _params) do
    	render conn, "index.html"
  	end

end