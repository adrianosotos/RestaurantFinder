import axios from "axios";
import { AxiosHttpClient } from "./AxiosClient";

jest.mock('axios');
const mockAxios = axios as jest.Mocked<typeof axios>;

describe('AxiosHttpClient', () => {
  it('fetches data successfully', async () => {
    const mockUrl = 'https://api.example.com/data';
    const mockData = { message: 'Success!' };

    mockAxios.request.mockResolvedValue({
      status: 200,
      data: mockData,
    });

    const client = new AxiosHttpClient();

    const response = await client.request({
      url: mockUrl,
      method: 'get',
    });

    expect(mockAxios.request).toHaveBeenCalledWith({
      url: mockUrl,
      method: 'get',
    });

    expect(response).toEqual({
      statusCode: 200,
      body: mockData,
    });
  });

  it('handles errors', async () => {
    const mockUrl = 'https://api.example.com/error';
    mockAxios.request.mockRejectedValue(new Error('Network error'));

    const client = new AxiosHttpClient();

    let messageError: string = '';
    try {
      await client.request({ url: mockUrl, method: 'get' })
    } catch (error) {
      messageError =(error as Error).message;
    } finally {
      expect(messageError).toBe('Network error');
    }


    expect(mockAxios.request).toHaveBeenCalledWith({
      url: mockUrl,
      method: 'get',
    });
  });
});
