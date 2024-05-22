import axios from 'axios'
import { HttpClient, HttpRequest, HttpResponse } from '../../core/ports/HttpService'

export class AxiosHttpClient implements HttpClient {
  async request (data: HttpRequest): Promise<HttpResponse> {
    try {
      const axiosResponse = await axios.request({
        url: data.url,
        method: data.method,
        data: data.body,
        headers: data.headers
      })

      return {
        statusCode: axiosResponse?.status,
        body: axiosResponse?.data
      }
    } catch (error: any) {
      throw new Error(error.message)
    }
  }
}
